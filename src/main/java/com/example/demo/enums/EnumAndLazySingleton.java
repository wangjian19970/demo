package com.example.demo.enums;

/**
 * 懒加载与枚举结合的单例模式
 */
public class EnumAndLazySingleton {
    private enum EnumSingleton{
        INSTANCE;
private static EnumAndLazySingleton instance = null;
        public  EnumAndLazySingleton getInstance(){
            if (instance ==null){
                instance = new EnumAndLazySingleton();
            }
            return instance;
        }
    }
    //懒加载 线程安全(多线程和单线程环境下，运行结果一直就是线程安全)而且不用加锁
    public static EnumAndLazySingleton getInstance(){
        return EnumSingleton.INSTANCE.getInstance();
    }
}
