package com.example.demo.dto;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table goods
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class Goods {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.goods_id
     *
     * @mbg.generated
     */
    private Long goodsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.goods_name
     *
     * @mbg.generated
     */
    private String goodsName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.goods_pics
     *
     * @mbg.generated
     */
    private String goodsPics;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.goods_price
     *
     * @mbg.generated
     */
    private Double goodsPrice;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.goods_id
     *
     * @return the value of goods.goods_id
     *
     * @mbg.generated
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.goods_id
     *
     * @param goodsId the value for goods.goods_id
     *
     * @mbg.generated
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.goods_name
     *
     * @return the value of goods.goods_name
     *
     * @mbg.generated
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.goods_name
     *
     * @param goodsName the value for goods.goods_name
     *
     * @mbg.generated
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.goods_pics
     *
     * @return the value of goods.goods_pics
     *
     * @mbg.generated
     */
    public String getGoodsPics() {
        return goodsPics;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.goods_pics
     *
     * @param goodsPics the value for goods.goods_pics
     *
     * @mbg.generated
     */
    public void setGoodsPics(String goodsPics) {
        this.goodsPics = goodsPics;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.goods_price
     *
     * @return the value of goods.goods_price
     *
     * @mbg.generated
     */
    public Double getGoodsPrice() {
        return goodsPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.goods_price
     *
     * @param goodsPrice the value for goods.goods_price
     *
     * @mbg.generated
     */
    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}