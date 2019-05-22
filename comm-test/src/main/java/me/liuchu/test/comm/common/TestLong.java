package me.liuchu.test.comm.common;

public class TestLong {

    private static void calcLong(){

        System.out.println("Max int："+Integer.MAX_VALUE);

        Long longNum = 3920200000L;

        int intMoney = (int)(longNum / 100000);

        System.out.println(intMoney);

    }

    public static void main(String[] args) {
        calcLong();
    }
}
