package me.liuchu.test.comm.common;

import java.util.Objects;

/**
 * @author liuchu
 * Date 2019/5/17
 * Time 11:29
 */
public class TestString {

    public static void test1() {
        System.out.println(Objects.equals("a", "a"));
    }

    public static void test2() {
        String source = "a,b,c,,";
        String[] arr = source.split(",");
        System.out.println("length:" + arr.length);
    }

    public static void main(String[] args) {
        test2();
    }


}
