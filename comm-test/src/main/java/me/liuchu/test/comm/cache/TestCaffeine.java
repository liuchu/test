package me.liuchu.test.comm.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

public class TestCaffeine {

    private static final Cache<Idempotent, Boolean> CACHE = Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build();

    private static final Cache<String, Boolean> CACHE2 = Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build();

    private void test() {
        Idempotent ide1 = new Idempotent();
        Idempotent ide2 = new Idempotent();

        System.out.println(ide1.hashCode());
        System.out.println(ide2.hashCode());

        CACHE.put(ide1, true);

        if (CACHE.getIfPresent(ide2) != null) {
            System.out.println(("同一方法正在执行"));
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~");

        String str1 = "A";
        String str2 = "B";
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

        CACHE2.put(str1, true);

        if (CACHE2.getIfPresent(str2) != null) {
            System.out.println(("同一方法正在执行"));
        }
    }

    private void testExpire() throws InterruptedException {
        final Cache<String, Integer> cache = Caffeine.newBuilder()
                .expireAfterWrite(2, TimeUnit.SECONDS)
                .build();

        cache.put("LIU", 10);
        System.out.println("Value in cache(get):" + cache.get("LIU", k -> -2));
        System.out.println("Value in cache(getIfPresent):" + cache.getIfPresent("LIU"));

        Thread.sleep(3000);
        System.out.println("key LIU Expired");

        //System.out.println("Value in cache(get):" + cache.get("LIU", k -> -2));
        System.out.println("Value in cache(getIfPresent):" + cache.getIfPresent("LIU"));

    }

    public static void main(String[] args) throws InterruptedException {
        new TestCaffeine().testExpire();
    }

}
