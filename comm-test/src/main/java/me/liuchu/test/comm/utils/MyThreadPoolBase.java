package me.liuchu.test.comm.utils;

import com.chuliu.demo.test.exception.ReachJobLimitationException;

public interface MyThreadPoolBase {

    void execute(Runnable job) throws ReachJobLimitationException;

    void shutdown();

    int getJobSize();

    int getWorkerSize();
}
