package com.example.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "/Goods相关实体")
public class GoodsParam {
    @ApiModelProperty(value = "商品id", required = true)//描述字段名
    private int id;
    @ApiModelProperty(value = "商品名", required = true)//描述字段名
    private String name;
    @ApiModelProperty(value = "商品类型", required = true)//描述字段名
    private String type;
    @ApiModelProperty(value = "商品颜色", required = true)//描述字段名
    private String color;
    @ApiModelProperty(value = "商品价格", required = true)//描述字段名
    private double price;
}
