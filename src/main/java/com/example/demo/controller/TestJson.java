package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;

import com.example.demo.utils.RedisUtils;
import com.example.demo.utils.ReturnResult;
import com.example.demo.utils.ReturnResultUtils;
import com.example.demo.vo.CheckVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "testJSON")
@RestController
@RequestMapping(value = "/test")
public class TestJson {
    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation(value = "setToRedis")
    @GetMapping(value = "/setToRedis")
    public ReturnResult setToRedis(){
        CheckVo checkVo=new CheckVo();
        checkVo.setId(1);
        checkVo.setAge(18);
        checkVo.setName("name");

        //将Java对象转化为json的字符串
        String jsonStr=JSONObject.toJSONString(checkVo);
       try {
           redisUtils.set("test_json_str",jsonStr);
           return ReturnResultUtils.returnSuccess(checkVo);
       }catch (Exception e){
           return ReturnResultUtils.returnFall(909,"redis连接异常");
       }

    }


    //从redis中将json字符串拿出来且转为Java对象
    @ApiOperation(value = "getFromRedis")
    @GetMapping(value = "/getFromRedis")
    public ReturnResult<CheckVo> getFromRedis(){
        String jsonStr=(String)redisUtils.get("test_json_str");

        CheckVo checkVo=JSONObject.parseObject(jsonStr,CheckVo.class);
        return  ReturnResultUtils.returnSuccess(checkVo);
        //将Java对象转化为json的字符串

    }
}
