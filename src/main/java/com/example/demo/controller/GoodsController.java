package com.example.demo.controller;


import com.example.demo.service.OrderService;
import com.example.demo.utils.RedisUtils;
import com.example.demo.utils.ReturnResult;
import com.example.demo.utils.ReturnResultUtils;
import com.example.demo.vo.CheckParam;
import com.example.demo.vo.CheckVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;

import java.util.List;

@Api(tags = "0.01/商品相关") //根菜单说明


@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private RedisUtils redisUtils;
    private String likeSum;

    //点赞接口：点赞和取消点赞用一个接口goodsId
    @ApiOperation(value = "点赞", notes = "like为1点赞为-1取消点赞") //接口说明
    @GetMapping(value = "/toLike")
    public void toLike(@ApiParam(value = "商品id", required = true) @RequestParam(required = false)
                               String goodsId, @RequestParam String userId, @RequestParam int like) {

        //判断该用户对产品是否点过赞并且这次来的又是点赞
        if (like == 1 && isLike(goodsId, userId)) {
            return;
        }
        redisUtils.lSet(goodsId + ":" + userId, like);
        //if(like==1)redisUtils.lSet(goodsId+":"+userId,1);
        //没有点赞的情况下
        // redisUtils.lSet(goodsId+":"+userId,-1);
        if (like == 1) {
            redisUtils.incr(likeSum + goodsId, 1);
        } else {
            redisUtils.incr(likeSum + goodsId, -1);
        }
    }

    //如果是点赞就传1，如果是取消点赞就传-1
    public boolean isLike(String goodsId, String userId) {
        List<Object> likes = redisUtils.lGet(goodsId + ":" + userId, 0, -1);
        int sum = 0;
        for (Object o : likes) {
            sum += Integer.valueOf(String.valueOf(o));
        }
        //当sum>0，点过赞了
        //likes.stream().mapToInt(l->1).sum();
        return sum > 0;
    }

    @ApiOperation(value = "点赞数量", notes = "返回点赞数")
    @GetMapping(value = "/likeSum")
    public ReturnResult<CheckVo> likeSum(@Validated CheckParam checkParam) {

        CheckVo checkVo = new CheckVo();
//        Object obj=redisUtils.get(likesSum+goodsId);
//        if(null!=obj)
//            return (int) obj;
        //CheckVo checkVos=Service.get(checkVo);
        return ReturnResultUtils.returnSuccess(checkVo);
    }

    @ApiOperation(value = "/抢购")
    @GetMapping(value = "/timeToBuy")
    public ReturnResult timeToBuy(@ApiParam(value = "商品id") @RequestParam long goodsId, HttpServletResponse request) {
        String token = request.getHeader("token");
        long userId = (long) redisUtils.get(token);
        if (StringUtils.isEmpty(userId)) {
            return ReturnResultUtils.returnFall(110, "请先登录");
        }
        orderService.Order(goodsId, userId);
        return ReturnResultUtils.returnSuccess();
    }
}
