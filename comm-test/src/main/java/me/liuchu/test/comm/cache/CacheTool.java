package me.liuchu.test.comm.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

public class CacheTool {

    private static Cache<Integer, Integer> SINGLE_INT_INSTANCE = Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .maximumSize(10_000)
            .build();

    private static Cache<String, String>  SINGLE_STRING_INSTANCE = Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .maximumSize(10_000)
            .build();

    public static Integer get(Integer key) {
        return SINGLE_INT_INSTANCE.getIfPresent(key);
    }

    public static void put(Integer key) {
        SINGLE_INT_INSTANCE.put(key, key);
    }

    public static void remove(Integer key) {
        SINGLE_INT_INSTANCE.invalidate(key);
    }

    public static long size() {
        return SINGLE_INT_INSTANCE.estimatedSize();
    }

    public static String getStr(String key) {
        return SINGLE_STRING_INSTANCE.getIfPresent(key);
    }

    public static void putStr(String key) {
        SINGLE_STRING_INSTANCE.put(key, key);
    }

    public static void removeStr(String key) {
        SINGLE_STRING_INSTANCE.invalidate(key);
    }

    public static long sizeStr() {
        return SINGLE_STRING_INSTANCE.estimatedSize();
    }
}
