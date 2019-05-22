package me.liuchu.test.comm.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class TestMap {

    private static void test() {
        HashMap<String, String> hashMap = new HashMap<>();
        TreeMap<String, String> treeMap = new TreeMap<>();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();

        hashMap.put("A", "a");
        hashMap.putIfAbsent("B", "b");

        hashMap.forEach((k, v) -> System.out.println(k + ":" + v));
        hashMap.clear();

        hashMap.computeIfAbsent("A", k -> k + "+" + k);

        hashMap.computeIfPresent("A", (k, v) -> k + "-" + v);

        /*hashMap.put("B", "b");*/
        hashMap.compute("B", (k,v) -> k + " * "+ v);

        hashMap.forEach((k, v) -> System.out.println(k + ":" + v));
/*
        hashMap.compute("Player1", k -> );
        hashMap.computeIfAbsent("Player2", "");
        hashMap.computeIfPresent("Player3");
*/
    }

    public static void main(String[] args) {
        test();
    }
}
