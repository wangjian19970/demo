package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import lombok.extern.log4j.Log4j;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.*;

@Log4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserMapper userMapper;

    @After
    public void after() {
        log.info("---------结束测试----------");
    }

    @Before
    public void init() {
        log.info("---------开始测试----------");
    }

    @Test
    public void test() {
        //断言立个falg
        //Assert.assertSame("数量不对","50000","50000");
       // Assert.assertNotSame("数量对", 1, 1);

        log.info("---------test----------");
    }

    @Test
    @Ignore
    public void tests() {
       log.info("---------忽略test注解----------");
   }
}