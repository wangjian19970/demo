package com.example.demo.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MD5UtilsTest {

    @Test
    public void getMD5Str() throws  Exception{
        MD5Utils.getMD5Str("admin");
    }
}