package me.liuchu.test.comm.concurrent;

public class TestThreadLocal {

    private final static ThreadLocal<Integer> uniqueId = new ThreadLocal<>();

    public TestThreadLocal( Integer id) {
        if (uniqueId.get() == null || uniqueId.get().equals(0)) {
            uniqueId.set(id);
        }
    }

    public ThreadLocal<Integer> getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(ThreadLocal<Integer> uniqueId) {
        uniqueId = uniqueId;
    }

    public static void main(String[] args) {
        ExecutorTool.EXECUTOR.execute(() -> System.out.println(new TestThreadLocal(101).getUniqueId().get()));
        ExecutorTool.EXECUTOR.execute(() -> System.out.println(new TestThreadLocal(102).getUniqueId().get()));
        ExecutorTool.EXECUTOR.execute(() -> System.out.println(new TestThreadLocal(103).getUniqueId().get()));

        System.out.println(new TestThreadLocal(111).getUniqueId().get());
        System.out.println(new TestThreadLocal(112).getUniqueId().get());
        System.out.println(new TestThreadLocal(113).getUniqueId().get());


    }
}
