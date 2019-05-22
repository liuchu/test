package me.liuchu.test.comm.data;

import java.util.stream.IntStream;

public class TestExtendStaticInnerClass {

    public static void main(String[] args) {

        IntStream.range(0,5).forEach(i -> System.out.println(i*i));
        IntStream.rangeClosed(0,5).forEach(i -> System.out.println(i*i));

        /*int a = 100212;
        System.out.println(a % 10);

        String str = "你好，Tom，今天是2018年";
        System.out.println(str.substring(0,1));*/
    }
}
