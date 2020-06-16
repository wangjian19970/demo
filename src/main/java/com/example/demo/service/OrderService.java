package com.example.demo.service;


import com.example.demo.dto.Order;
import com.example.demo.mapper.GoodsMapper;
import com.example.demo.mapper.OrderMapper;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    public boolean Order(long goodsId, long userId) {
        Order order = new Order();
        double goodsprice = GoodsMapper.selectByPrimaryKey(goodsId).getGoodsPrice();
        order.setGoodsId(goodsId);
        order.setGoodsPrice(goodsprice);
        orderMapper.insertSelective(order);
        return false;
    }


}
