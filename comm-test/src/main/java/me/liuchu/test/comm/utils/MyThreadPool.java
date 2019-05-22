package me.liuchu.test.comm.utils;

import com.chuliu.demo.test.exception.ReachJobLimitationException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyThreadPool implements MyThreadPoolBase {

    //最大工作者个数(线程池能同时执行的最大任务数)
    private static final int MAX_WORKER_SIZE = 20;

    //默认工作者个数(线程池能同时执行的最大任务数)
    private static final int DEFAULT_WORKER_SIZE = 5;

    //最大任务数(线程池最多接收的任务数)
    private static final int MAX_JOBS_SIZE = 1000;

    //工作者个数(线程池能同时执行的最大任务数)
    private int workerSize;

    //任务链表
    private final LinkedList<Runnable> jobList = new LinkedList<>();

    //工作者链表
    private final List<Worker> workerList = new ArrayList<>();

    /**
     * 无参构造函数
     */
    public MyThreadPool() {
        this.workerSize = DEFAULT_WORKER_SIZE;
        init();
    }

    /**
     * 指定worker数量的构造函数
     *
     * @param workerSize 工作者数量
     */
    public MyThreadPool(int workerSize) {
        this.workerSize = workerSize > 0 && workerSize <= MAX_WORKER_SIZE ? workerSize : DEFAULT_WORKER_SIZE;
        init();
    }

    /**
     * 初始化
     */
    private void init(){
        for (int i = 0; i < workerSize; i++) {
            Worker worker = new Worker();
            workerList.add(worker);
            Thread t = new Thread(worker);
            t.setName("MyThreadPool-work-no-"+i);
            t.start();
        }
    }

    @Override
    public void execute(Runnable job) throws ReachJobLimitationException {
        synchronized (jobList) {
            if (jobList.size() < MAX_JOBS_SIZE){
                jobList.add(job);
                jobList.notify();
            }else throw new ReachJobLimitationException("Can not execute this task, the thread pool have reached its capability.");
        }
    }

    @Override
    public void shutdown() {

        for (Worker worker : workerList){
            worker.stop();
        }
    }

    @Override
    public int getJobSize() {
        return jobList.size();
    }

    @Override
    public int getWorkerSize() {
        return workerList.size();
    }

    public class Worker implements Runnable {

        private boolean active = true;

        @Override
        public void run() {

            while (active){
                Runnable job;

                synchronized (jobList){

                    if (jobList.size() == 0){
                        try {
                            jobList.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return;
                        }
                    }

                    job = jobList.removeFirst();
                }

                job.run();
            }
        }

        void stop(){
            active = false;
        }
    }
}
