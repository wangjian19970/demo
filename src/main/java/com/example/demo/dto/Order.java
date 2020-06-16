package com.example.demo.dto;

import com.example.demo.utils.UUIDUtils;

import java.util.Date;

/**
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table order
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class Order {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.order_id
     *
     * @mbg.generated
     */
    private String orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.goods_id
     *
     * @mbg.generated
     */
    private Long goodsId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.pay
     *
     * @mbg.generated
     */
    private Integer pay;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.goods_price
     *
     * @mbg.generated
     */
    private Double goodsPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.order_id
     *
     * @return the value of order.order_id
     * @mbg.generated
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.order_id
     *
     * @param orderId the value for order.order_id
     * @mbg.generated
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.goods_id
     *
     * @return the value of order.goods_id
     * @mbg.generated
     */
    public Long getGoodsId() {

        return goodsId;
    }

    public String getId() {
        return UUIDUtils.getUUID();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.goods_id
     *
     * @param goodsId the value for order.goods_id
     * @mbg.generated
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.pay
     *
     * @return the value of order.pay
     * @mbg.generated
     */
    public Integer getPay() {
        return pay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.pay
     *
     * @param pay the value for order.pay
     * @mbg.generated
     */
    public void setPay(Integer pay) {
        this.pay = pay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.goods_price
     *
     * @return the value of order.goods_price
     * @mbg.generated
     */
    public Double getGoodsPrice() {
        return goodsPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.goods_price
     *
     * @param goodsPrice the value for order.goods_price
     * @mbg.generated
     */
    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.create_time
     *
     * @return the value of order.create_time
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.create_time
     *
     * @param createTime the value for order.create_time
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.update_time
     *
     * @return the value of order.update_time
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.update_time
     *
     * @param updateTime the value for order.update_time
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}