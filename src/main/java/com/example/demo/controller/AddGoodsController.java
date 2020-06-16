package com.example.demo.controller;

import com.example.demo.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "0.01/添加商品")
@RestController
@RequestMapping(value = "/goods")
public class AddGoodsController {
    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation(value = "添加商品", notes = "返回内存中的商品")
    @GetMapping(value = "/addGoods")
    public String addGoods(@RequestParam int id, @RequestParam String name,
                           @RequestParam String type, @RequestParam String color,
                           @RequestParam double price) {
        redisUtils.hset("name", "id", "id");
        redisUtils.hset("name", "id", "name");
        redisUtils.hset("name", "id", "type");
        redisUtils.hset("name", "id", "color");
        redisUtils.hset("name", "id", "price");

        return name;
    }

}
