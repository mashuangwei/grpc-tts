package com.tts.grpc;

import io.grpc.stub.StreamObserver;
import java.util.concurrent.CountDownLatch;

/**
 * @author mashuangwei
 * @create 2018-01-31 16:27
 **/

public class StreamObserverImpl<T> implements StreamObserver<T> {
    private int status = 0;
    private CountDownLatch countDownLatch;

    public void onNext(T t) {
        System.err.println("onNext.....");
    }

    public void onError(Throwable throwable) {
        System.err.println("onError");
        this.status = -1;
        countDownLatch.countDown();
    }

    public void onCompleted() {
        System.err.println("onCompleted");
        status = 0;
        countDownLatch.countDown();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
}
