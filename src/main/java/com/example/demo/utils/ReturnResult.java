package com.example.demo.utils;


import lombok.Data;

import java.io.Serializable;
@Data
public class ReturnResult<T> implements Serializable {
    //code状态码
    private Integer code;
    private String message;
    private T data;

}
