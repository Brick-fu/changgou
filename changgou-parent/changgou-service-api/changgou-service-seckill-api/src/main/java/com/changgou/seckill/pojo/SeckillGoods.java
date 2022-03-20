package com.changgou.seckill.pojo;

import java.util.Date;
import java.io.Serializable;
import java.util.Set;

/**
 * (SeckillGoods)实体类
 *
 * @author makejava
 * @since 2022-03-19 14:00:27
 */
public class SeckillGoods implements Serializable {
    private static final long serialVersionUID = -31099898833014293L;
    
    private Long id;
    /**
     * spu ID
     */
    private Long spuId;
    /**
     * sku ID
     */
    private Long skuId;
    /**
     * 标题
     */
    private String name;
    /**
     * 商品图片
     */
    private String smallPic;
    /**
     * 原价格
     */
    private Double price;
    /**
     * 秒杀价格
     */
    private Double costPrice;
    /**
     * 添加日期
     */
    private Date createTime;
    /**
     * 审核日期
     */
    private Date checkTime;
    /**
     * 审核状态，0未审核，1审核通过，2审核不通过
     */
    private String status;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 秒杀商品数
     */
    private Integer num;
    /**
     * 剩余库存数
     */
    private Integer stockCount;
    /**
     * 描述
     */
    private String introduction;

    private Set ids;

    public Set getIds() {
        return ids;
    }

    public void setIds(Set ids) {
        this.ids = ids;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "SeckillGoods{" +
                "id=" + id +
                ", spuId=" + spuId +
                ", skuId=" + skuId +
                ", name='" + name + '\'' +
                ", smallPic='" + smallPic + '\'' +
                ", price=" + price +
                ", costPrice=" + costPrice +
                ", createTime=" + createTime +
                ", checkTime=" + checkTime +
                ", status='" + status + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", num=" + num +
                ", stockCount=" + stockCount +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}

