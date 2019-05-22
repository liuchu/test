package me.liuchu.test.comm.common;

import java.math.BigDecimal;

/**
 * @author liuchu
 * Date 2019/5/16
 * Time 11:15
 */
public class TestBigDemical {

    public static void test(){
        BigDecimal num1 = new BigDecimal(5.44);
        System.out.println(num1.doubleValue());


        BigDecimal num2 = new BigDecimal("5.44");
        System.out.println(num2.doubleValue());

    }

    public static void main(String[] args) {
        test();
    }
}
