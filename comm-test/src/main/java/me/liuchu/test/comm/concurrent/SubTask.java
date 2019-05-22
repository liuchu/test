package me.liuchu.test.comm.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Fork task
 */
public class SubTask extends RecursiveTask<Integer> {

    private int[] arr;

    private final static int THRESHOLD = 20;

    public SubTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected Integer compute() {
        //数组长度超过20就将该task分成2个子任务
        if (arr.length > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubTasks(arr)).stream().mapToInt(RecursiveTask::join).sum();
        } else {
            return processing(arr);
        }
    }

    private List<SubTask> createSubTasks(int[] subArr) {
        List<SubTask> subs = new ArrayList<>();
        subs.add(new SubTask(Arrays.copyOfRange(subArr, 0, subArr.length / 2 - 1)));
        subs.add(new SubTask(Arrays.copyOfRange(subArr, subArr.length / 2, subArr.length)));
        return subs;
    }

    private Integer processing(int[] arr) {
        return Arrays.stream(arr)
                .filter(a -> a > 10 && a < 27)
                .map(a -> a * 10)
                .sum();
    }
}
