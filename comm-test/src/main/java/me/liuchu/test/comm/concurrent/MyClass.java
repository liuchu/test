package me.liuchu.test.comm.concurrent;

import java.io.FileNotFoundException;

public class MyClass implements MyInterface{

    @Override
    public void doSth() {
        //定义的接口未抛出异常，实现类不能throws
        //throw new FileNotFoundException("a");
    }
}
