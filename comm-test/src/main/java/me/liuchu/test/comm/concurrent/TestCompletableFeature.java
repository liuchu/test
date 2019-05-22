package me.liuchu.test.comm.concurrent;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

public class TestCompletableFeature {

    @Test
    public void completedFutureExample() {
        CompletableFuture<String>cf = CompletableFuture.completedFuture("message");
        Assert.assertTrue(cf.isDone());
        Assert.assertEquals("message", cf.getNow(null));
    }
}
