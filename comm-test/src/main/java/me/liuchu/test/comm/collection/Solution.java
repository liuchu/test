package me.liuchu.test.comm.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Solution {

    private static List<Integer> sSorted = new LinkedList<>();

    public static void addElement(int e) {

        if (sSorted.size() == 0) {
            sSorted.add(e);
            return;
        }

        ListIterator<Integer> iterator = sSorted.listIterator();

        while (iterator.hasNext()) {
            Integer num = iterator.next();

            if (e <= num) {
                iterator.previous();
                iterator.add(e);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Solution.addElement(3);
        Solution.addElement(2);
        Solution.addElement(1);
        Solution.addElement(2);

        for (Integer e : Solution.sSorted) {
            System.out.println(e);
        }
    }
}
