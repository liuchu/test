package me.liuchu.test.comm.collection;

import org.apache.commons.collections4.CollectionUtils;

import java.util.*;
import java.util.stream.IntStream;

public class TestArray {

    public static void distinct() {
        Integer[] arr = new Integer[]{3435487,
                3388855,
                3435487,
                3770017,
                3388855,
                3770017,
                3435487,
                3388855,
                4368034,
                4369580,
                4369848,
                3435487,
                4398491,
                4361300,
                4364931,
                4361798,
                4362047,
                4393910,
                4393966,
                4394103,
                4367003,
                4373836,
                3770017,
                3388855,
                4374253,
                4372705,
                4405349,
                4405826,
                4381709,
                4390369,
                4390574,
                4387676,
                4391056,
                4401284,
                4401666,
                4384188,
                4402196,
                4392499,
                4380656,
                4392499,
                4393910,
                4393966,
                4394103,
                4398491,
                4401284,
                4401666,
                4361300,
                4402196,
                4361798,
                4362047,
                4405349,
                4364931,
                4405826,
                4367003,
                4368034,
                4369580,
                4369848,
                4372705,
                4373836,
                4374253,
                4380656,
                4381709,
                4384188,
                4387676,
                4390369,
                4390574,
                4391056,
                3388855,
                3435487,
                3770017
        };

        List<Integer> list = Arrays.asList(arr);

        Set<Integer> set = new HashSet<>(list);

        for (Integer num : set) {
            System.out.print(num + ", ");
        }

    }

    public static void testEmptyList() {
        List<Integer> list = new ArrayList<>();

        for (Integer i :
                list) {
            System.out.println(i);
        }
    }

    public static void testApacheCommonCollections() {

        List<String> biggerArr = Arrays.asList("Today", "is", "a", "good", "day");
        List<String> smallerArr = Arrays.asList("You", "are", "a", "good", "man");

        List<String> subtractList = new ArrayList<>(CollectionUtils.subtract(biggerArr, smallerArr));

        List<String> unionList = new ArrayList<>(CollectionUtils.union(biggerArr, smallerArr));

        List<String> intersectionList = new ArrayList<>(CollectionUtils.intersection(biggerArr, smallerArr));

        System.out.println("The subtract collection of input array:");
        subtractList.forEach(System.out::println);
        System.out.println("--------------------");

        System.out.println("The union collection of input array:");
        unionList.forEach(System.out::println);
        System.out.println("--------------------");

        System.out.println("The intersection collection of input array:");
        intersectionList.forEach(System.out::println);

    }

    private static void testSubList() {
        List<String> list = new ArrayList<>();
        IntStream.range(0, 9).forEach(num -> list.add(String.valueOf(num)));

        System.out.println("Origin list");
        list.forEach(System.out::print);

        list.subList(3, 8).clear();
        System.out.println("List after subList&clear");
        list.forEach(System.out::print);

        //list.toArray(new String[]{});
    }

    private static void testRemove() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        for (String item : list) {

            System.out.println(item);
            if ("1".equals(item)) {
                list.remove(item);
            }

        }
        System.out.println("size:" + list.size());
        list.forEach(System.out::print);
    }

    private static void testIterator() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        Iterator<String> iter = list.iterator();

        list.remove(2);

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public static void main(String[] args) {
        //distinct();
        testRemove();
    }

}
