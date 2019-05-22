package me.liuchu.test.comm.concurrent;

import com.chuliu.demo.test.mvel.entry.Student;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Compare and Swap(CAS)
 */

public class TestCAS {

    private int value = 0;
    private AtomicInteger valueInMem = new AtomicInteger(value);

    private AtomicReference<Student> atomicReference = new AtomicReference<>(new Student(1,1,1));
    private AtomicStampedReference<Student> stampedReference = new AtomicStampedReference<>(new Student(2,2,2), (int)System.currentTimeMillis()/1000);

    private void cas1(){
        atomicReference.compareAndSet(atomicReference.get(), new Student(3,3,3));
    }

    private void cas2(){

        stampedReference.compareAndSet(stampedReference.getReference(), new Student(4,4,4),
                stampedReference.getStamp(), (int)System.currentTimeMillis()/1000);
    }

    public int getValue(){
        return value;
    }

    public void setValue(int expect, int next) {

        for (;;) {
            if (valueInMem.get() == expect) {
                valueInMem.set(next);
                this.value = next;
                return;
            }

        }
    }

    public void increase(){

        int next = value + 1;

        setValue(value, next);
    }

    public void increaseTimes(int times) {
        for (int i = 0; i < times; i++) {
            increase();
        }
    }

    public static void main(String[] args) {
        TestCAS testCAS = new TestCAS();

        for (int i = 0; i < 10; i++) {
            ExecutorTool.EXECUTOR.execute(() -> testCAS.increaseTimes(1000000));
        }

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Result: "+testCAS.getValue());


    }

}
