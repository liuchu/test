package me.liuchu.test.comm.cache;

public class Task {

    private final static Object LOCK = new Object();


    public void doSth(Integer id){

        synchronized (LOCK) {
            if (CacheTool.get(id) != null) {
                System.out.println("订单正在被其他线程审核");
                return;
            }
            CacheTool.put(id);
        }

        try {
            Thread.sleep(15000);
            System.out.println("订单处理成功");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            CacheTool.remove(id);
        }

    }

}
