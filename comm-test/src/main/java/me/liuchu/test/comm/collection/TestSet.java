package me.liuchu.test.comm.collection;

import java.util.*;

public class TestSet {

    private static void test() {

        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("b");
        treeSet.add("c");
        treeSet.add("a");

        treeSet.forEach(System.out::print);
    }

    private static void distinctBySet() {
        List<String> lst = new ArrayList<>();

        lst.add("b");
        lst.add("a");
        lst.add("b");
        lst.add("c");

        Set<String> set = new HashSet<>(lst);
        set.forEach(System.out::print);
    }

    public static void main(String[] args) {
        distinctBySet();
    }
}
