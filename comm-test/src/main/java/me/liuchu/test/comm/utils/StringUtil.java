package me.liuchu.test.comm.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.Executors;

public class StringUtil {

    public static String genRandom64Str(){
        int length = 64;
        return RandomStringUtils.random(length, true, true);

    }

    public static void main(String[] args) {
        System.out.println("cache.solo_success.".length());
    }
}
