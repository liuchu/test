package me.liuchu.test.comm.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestLambda {

    public void mockUpdateLists(List<String> items){
        System.out.println("update list "+items.size());
    }

    public void test(){
        List<String> lists = new ArrayList<>();
        lists.addAll(Arrays.asList("A","B","C","D","E" ));
    }

    public static void main(String[] args) {

    }
}
