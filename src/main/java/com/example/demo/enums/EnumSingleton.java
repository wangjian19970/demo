package com.example.demo.enums;

/**
 * 枚举类的单例模式，语法糖：由Java保证枚举的唯一性
 */
public enum EnumSingleton {
    INSTANCE;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
