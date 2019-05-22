package me.liuchu.test.comm.common;

import com.chuliu.demo.test.exception.ExceptionDemo;
import com.chuliu.demo.test.exception.RunTimeExceptionDemo;

public class TestExceptionMechanism {

    public void runningAndMeetException() throws ExceptionDemo {
        for (int i=0;i<100;i++){
            if (i==50)
                throw new ExceptionDemo("Meet a exception");
        }
    }

    public void runningAndMeetRuntimeException(int num) {
        if (num>=50)
            throw new RunTimeExceptionDemo("Meet a exception");
    }

    public void doSomeElse(){
        System.out.println("OK, the extra works are done");
    }

    public void what(int num){
        runningAndMeetRuntimeException(num);
        doSomeElse();
    }

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                TestExceptionMechanism test = new TestExceptionMechanism();
                test.what(30);
            }
        }).start();

        System.out.println("---------");

        new Thread(new Runnable() {
            @Override
            public void run() {
                TestExceptionMechanism test = new TestExceptionMechanism();
                test.what(60);
            }
        }).start();
    }
}
