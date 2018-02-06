package com.tts.grpc;

import io.grpc.stub.StreamObserver;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CountDownLatch;

/**
 * @author mashuangwei
 * @create 2018-01-31 16:27
 **/
@Slf4j
@Data
public class StreamObserverImpl<T> implements StreamObserver<T> {
    private int status = 0;
    private CountDownLatch countDownLatch;

    public void onNext(T t) {
        log.info("onNext.....");
    }

    public void onError(Throwable throwable) {
        log.info("onError");
        countDownLatch.countDown();
    }

    public void onCompleted() {
        log.info("onCompleted");
        status = 0;
        countDownLatch.countDown();
    }

}
