package com.changgou.search;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestApplication {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void testDelete() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("skuinfo","docs","1148477873355497472");
        DeleteResponse deleteResponse = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(deleteResponse.status());
    }

    @Test
    public void testQuery() throws IOException {
        SearchRequest searchRequest = new SearchRequest("skuinfo");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchAllQuery()).from(1).size(10)
                .postFilter(QueryBuilders.matchQuery("name","华为"));
        searchRequest.types("docs").source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();
        for (SearchHit hit:hits) {
            System.out.println("-----1----" + hit.getFields());
            System.out.println("-----2----" + hit.getSourceAsMap());
            System.out.println("-----3----" + hit.getSourceAsString());
            System.out.println("-----4----" + hit.getIndex());
            System.out.println("-----5----" + hit.getType());
        }
        System.out.println("索引库总条数：" + searchResponse.getHits().getTotalHits());
    }

    public void testAdd(){

    }

    @Test
    public void testSearch(){

    }
}
