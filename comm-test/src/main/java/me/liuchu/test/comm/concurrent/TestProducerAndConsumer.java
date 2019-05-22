package me.liuchu.test.comm.concurrent;

import com.sun.istack.internal.NotNull;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class TestProducerAndConsumer {

    public static class MyProducer implements Runnable{

        private String name;
        private final Queue<Integer> queue;
        private final static Integer THRESHOLD = 10;

        public MyProducer(String name,@NotNull Queue<Integer> queue) {
            if (queue == null) {
                throw new RuntimeException("argument 'queue' can't be null while initial a MyProducer");
            }
            this.name = name;
            this.queue = queue;
        }

        public void produce() {

            while (true) {
                synchronized (queue) {
                    //一次生产100条
                    while (queue.size() < THRESHOLD) {
                        Random random = new Random();
                        Integer item = random.nextInt(10000);
                        queue.offer(item);
                        System.out.println(name+" produced "+item);
                    }

                    //100条了通知消费者
                    queue.notifyAll();
                }
            }

        }

        @Override
        public void run() {
            produce();
        }
    }

    public static class MyConsumer implements Runnable{

        private String name;
        private Queue<Integer> queue;
        private final static Integer ZERO = 0;

        public MyConsumer(String name, @NotNull Queue<Integer> queue) {
            if (queue == null) {
                throw new RuntimeException("argument 'queue' can't be null while initial a MyConsumer");
            }
            this.name = name;
            this.queue = queue;
        }

        public void consume() throws InterruptedException {

            while (true) {
                Thread.sleep(5 * 1000);
                synchronized (queue) {
                    //一旦没有"消费品"了，等待
                    while (queue.size() == ZERO) {
                        queue.wait();
                    }
                    Integer item = queue.poll();
                    System.out.println(name+" consumed "+item);
                }
            }
        }

        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testIt(){

        Queue<Integer> queue = new ArrayDeque<>();

        Thread producerSingle = new Thread(new MyProducer("生产者", queue));
        Thread consumer1 = new Thread(new MyConsumer("消费者101", queue));
        Thread consumer2 = new Thread(new MyConsumer("消费者202", queue));
        Thread consumer3 = new Thread(new MyConsumer("消费者303", queue));
        Thread consumer4 = new Thread(new MyConsumer("消费者404", queue));
        Thread consumer5 = new Thread(new MyConsumer("消费者505", queue));

        consumer1.start();
        consumer2.start();
        producerSingle.start();
        consumer3.start();
        consumer4.start();
        consumer5.start();
    }

    public static void main(String[] args) {
        testIt();
    }

}
