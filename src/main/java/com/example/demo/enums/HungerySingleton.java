package com.example.demo.enums;

/**
 * 单例模式 定义：一个类中有且仅有一个对象，并且向整个项目提供这个对象
 * 单例模式：饿汉模式和懒汉模式
 */
public class HungerySingleton {
    private static HungerySingleton hungerySingleton = new HungerySingleton();

    public static HungerySingleton getinstance() {
        return hungerySingleton;
    }
}
