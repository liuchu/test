package me.liuchu.test.comm.mvel;

import com.chuliu.demo.test.mvel.lambda.*;

public class TestLambda {

    public static void testLambda(){
        LambdaSampleNoArgNoReturn sample1 = () -> System.out.println("no args, no return");

        LambdaSampleNoArgNoReturn sample12 = () -> System.out.println("no args, no return");

        LambdaSampleNoArgHaveReturn sample2 = () -> 1+2;

        LambdaSampleOneArgHaveReturn sample3 = (a) -> a*2;

        LambdaSampleManyArgHaveReturn sample4 = (a,b) -> a+b;

    }


}
