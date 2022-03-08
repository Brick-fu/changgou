package com.changgou.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.changgou.common.entity.Result;
import com.changgou.common.enums.GoodsEnum;
import com.changgou.goods.feign.SkuFeign;
import com.changgou.goods.pojo.Sku;
import com.changgou.search.dao.SkuEsDao;
import com.changgou.search.pojo.SkuInfo;
import com.changgou.search.service.SkuEsService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

@Service
public class SkuEsServiceImpl implements SkuEsService {

    @Autowired
    private SkuEsDao skuEsDao;
    @Autowired
    private SkuFeign skuFeign;
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    private final Logger logger = LoggerFactory.getLogger(SkuEsServiceImpl.class);


    /*
     * @Desc 导入数据到es
     * @Date 下午8:47 2021/10/13
     * @Author brick
     **/
    @Override
    public void importSku() {
        Result<List<Sku>> skuResult = skuFeign.findByStatus(GoodsEnum.GOODS_STATE_NORMAL.getCode());
        List<Sku> skus = skuResult.getData();
        logger.info("SkuEsServiceImpl.importSku,size:{}",skus.size());
        List<SkuInfo> skuInfos = JSON.parseArray(JSON.toJSONString(skus), SkuInfo.class);
        for (SkuInfo skuInfo:skuInfos) {
            Map<String,Object> map = JSON.parseObject(skuInfo.getSpec());
            skuInfo.setSpecMap(map);
        }
        skuEsDao.saveAll(skuInfos);
    }
    
    /*
     * @Desc 全局搜索
     * @Date 下午10:49 2021/10/19
     * @Author brick
     **/
    @Override
    public Map<String,Object> search(Map<String,String> condition) throws IOException {
        String keyword = condition.get("keyword");
        String brand = condition.get("brand");
        String category = condition.get("category");

        SearchRequest searchRequest = new SearchRequest("skuinfo");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //多条件查询
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        if(!StringUtils.isEmpty(keyword)){
            //根据关键字获取商品列表
            boolQueryBuilder.must(QueryBuilders.termQuery("name",keyword));
        }
        if(!StringUtils.isEmpty(brand)){
            boolQueryBuilder.must(QueryBuilders.termQuery("brandName",brand));
        }
        if(!StringUtils.isEmpty(category)){
            boolQueryBuilder.must(QueryBuilders.termQuery("categoryName",category));
        }

        //规格过滤查询
        for (String key : condition.keySet()) {
            if(key.contains("spec_")){
                boolQueryBuilder.must(QueryBuilders.termQuery("specMap." + key.substring(5) + ".keyword",condition.get(key)));
            }
        }

        //价格区间搜索
        String price = condition.get("price");
        if(!StringUtils.isEmpty(price)){
            price = price.replace("元","").replace("以上","");
            String[] prices = price.split("-");
            if(prices.length > 1){
                boolQueryBuilder.must(QueryBuilders.rangeQuery("price").from(prices[0],true).to(prices[1],false));
            }else{
                boolQueryBuilder.must(QueryBuilders.rangeQuery("price").gte(prices[0]));
            }
        }

        searchSourceBuilder.postFilter(boolQueryBuilder);

        //分页查询
        Integer pageNum = 1;
        String pageNumStr = condition.get("pageNum");
        if (!StringUtils.isEmpty(pageNumStr)) {
            try {
                pageNum = Integer.valueOf(pageNumStr);
            } catch (NumberFormatException e) {
                logger.error("页码转换错误！",e);
            }
        }
        Integer pageSize = 30;
        searchSourceBuilder.from(pageNum - 1).size(pageSize);

        //排序查询
        String sortRule = condition.get("sortRule");
        String sortField = condition.get("sortField");
        if(!StringUtils.isEmpty(sortField) && !StringUtils.isEmpty(sortRule)){
            searchSourceBuilder.sort(sortField,"DESC".equals(sortRule)? SortOrder.DESC:SortOrder.ASC);
        }

        //高亮显示
        searchSourceBuilder.highlighter(new HighlightBuilder().field("name")
                .preTags("<span style=\"color:red;\">")
                .postTags("</span>"));
        searchRequest.types("docs").source(searchSourceBuilder);
        SearchResponse queryResult = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        List<SkuInfo> skuInfoList = new ArrayList<>();
        SearchHits hits = queryResult.getHits();
        for (SearchHit hit : hits) {
            SkuInfo skuInfo = JSON.parseObject(hit.getSourceAsString(), SkuInfo.class);
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            //获取高亮值
            if(highlightFields.containsKey("name")){
                skuInfo.setName(String.valueOf(highlightFields.get("name").getFragments()[0]));
            }
            skuInfoList.add(skuInfo);
        }
        //分类名称聚合分组查询
        Map<String, Object> groupMap = searchGroupList(searchRequest, searchSourceBuilder,condition);
        Map<String,Object> resultMap = new HashMap<>(groupMap);

        //6.返回结果
        resultMap.put("rows", skuInfoList);
        resultMap.put("total", hits.totalHits);
        resultMap.put("totalPages", "");
        return resultMap;
    }

    private Map<String,Object>  searchGroupList(SearchRequest searchRequest, SearchSourceBuilder searchSourceBuilder,Map<String,String> condition) throws IOException {
        //分类分组
        if(condition == null || condition.get("categoryName").isEmpty()){
            AggregationBuilder categoryAggregationBuilder = AggregationBuilders.terms("skuCategory").field("categoryName.keyword").size(50);
            searchSourceBuilder.aggregation(categoryAggregationBuilder);
        }
        //品牌分组
        if(condition == null || condition.get("brandName").isEmpty()){
            AggregationBuilder brandAggregationBuilder = AggregationBuilders.terms("skuBrand").field("brandName.keyword").size(50);
            searchSourceBuilder.aggregation(brandAggregationBuilder);
        }
        AggregationBuilder specAggregationBuilder = AggregationBuilders.terms("skuSpec").field("spec.keyword").size(50);
        Map<String,Object> resultMap = new HashMap<>();
        SearchSourceBuilder aggregation = searchSourceBuilder.aggregation(specAggregationBuilder);
        searchRequest.types("docs").source(aggregation);
        SearchResponse aggregationResult = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        if(condition == null || condition.get("categoryName").isEmpty()){
            Terms categoryTerms = aggregationResult.getAggregations().get("skuCategory");
            List<String> categoryList = getGroupList(categoryTerms);
            resultMap.put("categoryList",categoryList);
        }
        if(condition == null || condition.get("brandName").isEmpty()){
            Terms brandTerms = aggregationResult.getAggregations().get("skuBrand");
            List<String> brandList = getGroupList(brandTerms);
            resultMap.put("brandList",brandList);
        }
        Terms specTerms = aggregationResult.getAggregations().get("skuSpec");
        List<String> specList = getGroupList(specTerms);
        Map<String,Set<String>> specMap = new HashMap<>();
        //规格合并
        for (String spec : specList) {
            Map<String,String> map = JSON.parseObject(spec, Map.class);
            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                Set<String> specValue = specMap.get(key);
                if(specValue == null){
                    specValue = new HashSet<>();
                }
                specValue.add(map.get(key));
                specMap.put(key,specValue);
            }
        }

        resultMap.put("specList",specMap);
        return resultMap;
    }



    private List<String> getGroupList(Terms terms) {
        List<String> list = new ArrayList<>();
        for (Terms.Bucket bucket : terms.getBuckets()) {
            String name = bucket.getKeyAsString();
            list.add(name);
        }
        return list;
    }
}
