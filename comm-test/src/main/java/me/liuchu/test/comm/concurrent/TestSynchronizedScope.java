package me.liuchu.test.comm.concurrent;

public class TestSynchronizedScope {

    private void normalMethod(){
        System.out.println("Invoke normal method");
    }

    private synchronized void syncMethod(){
        System.out.println("Invoke sync method");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestSynchronizedScope obj = new TestSynchronizedScope();
        ExecutorTool.EXECUTOR.execute(obj::syncMethod);
        ExecutorTool.EXECUTOR.execute(obj::normalMethod);
    }
}
