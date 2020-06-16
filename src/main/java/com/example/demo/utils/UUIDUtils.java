package com.example.demo.utils;

import java.util.UUID;

public class UUIDUtils {
    public static String getUUID(){
        String uuid=UUID.randomUUID().toString();
        return uuid.replaceAll("-","").substring(0,10);
    }
}
