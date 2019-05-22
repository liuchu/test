package me.liuchu.test.comm.concurrent;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
    Demo for CyclicBarrier
 */
public class CyclicBarrierDemo {

    private static CyclicBarrier cb;

    static class TicketThread implements Runnable{

        String name;

        public TicketThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("处理订单中："+name);

            System.out.println("订票成功："+name);

            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                System.out.println("BrokenBarrierException");
                e.printStackTrace();
            }

            System.out.println("出票中："+name);

        }
    }

    public static void bookTicket(String[] names){
        cb = new CyclicBarrier(names.length, () -> System.out.println("所有订单已处理完毕,准备统一出票"));

        Arrays.stream(names).forEach(name -> new Thread(new TicketThread(name)).start());
    }

    public static void main(String[] args) {
        bookTicket(new String[]{"A","B","C","D"});
    }


}
