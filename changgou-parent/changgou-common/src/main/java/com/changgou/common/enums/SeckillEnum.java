package com.changgou.common.enums;

/*
 * @Desc 秒杀状态
 * @Date 下午11:36 2022/3/19
 * @Author brick
 **/
public enum SeckillEnum {
    /*
     * @Desc 秒杀状态  1:排队中，2:秒杀等待支付,3:支付超时，4:秒杀失败,5:支付完成
     * @Date 下午11:36 2022/3/19
     * @Author brick
     **/
    QUEUING(1,"排队中"),
    SECKILL_WAITING_FOR_PAYMENT(2,"秒杀等待支付"),
    PAYMENT_TIMEOUT(3,"支付超时"),
    SECKILL_FAIL(4,"秒杀失败"),
    PAYMENT_COMPLETED(5,"支付完成"),
    ;

    private Integer code;

    private String desc;

    SeckillEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
