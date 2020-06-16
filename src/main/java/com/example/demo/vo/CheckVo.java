package com.example.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "check相关实体")//描述实体
public class CheckVo {
    @ApiModelProperty(value = "编号", required = true)//描述字段名
    private int id;
    @ApiModelProperty(value = "名字", required = true)//描述字段名
    private String name;
    @ApiModelProperty(value = "年龄", required = true)//描述字段名
    private int age;

}