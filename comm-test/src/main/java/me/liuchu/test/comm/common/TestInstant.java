package me.liuchu.test.comm.common;

import java.time.Instant;

/**
 * @author liuchu
 * Date 2019/5/20
 * Time 17:09
 */
public class TestInstant {

    private static void testInstant() {
        Instant nowInst = Instant.now();
        System.out.println(nowInst.getEpochSecond());

        System.out.println("---");

        Instant customizedInst = Instant.parse("1970-01-01T02:00:00.00Z");
        System.out.println(customizedInst);
        System.out.println(customizedInst.getEpochSecond());
    }

    public static void main(String[] args) {
        testInstant();
    }
}
