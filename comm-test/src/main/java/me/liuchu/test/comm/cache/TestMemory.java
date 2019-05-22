package me.liuchu.test.comm.cache;

import com.chuliu.demo.test.utils.StringUtil;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.LinkedList;
import java.util.List;

public class TestMemory {

    private static List<String> addresses = new LinkedList<>();

    /*static {
        for (int i=0; i<4000_000; i++) {
            addresses.add(StringUtil.genRandom64Str());
        }
    }*/

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            Thread.sleep(5000);
            System.out.println(TestMemory.addresses.hashCode());
        }
    }

}
