package com.tts.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import rokid.inner.Tts;
import rokid.inner.TtsServiceGrpc;

import java.io.*;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/**
 * tts性能测试
 *
 * @author mashuangwei
 * @create 2018-01-29 13:54
 **/

public class GrpcTts {

    public static void main(String args[]) {
        asynTts();
//        getAudio("172.31.8.3", 30000, "pcm", "e2e", "今天天气怎么样", 24000);
//        asynGrpc("172.31.8.3", 30000, "pcm", "e2e", "今天天气怎么样", 24000);
    }

    public static void asynTts() {
        String serverURI = "172.31.8.3";
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverURI, 30000).usePlaintext(true).build();
        TtsServiceGrpc.TtsServiceBlockingStub ttsServiceBlockingStub = TtsServiceGrpc.newBlockingStub(channel);

        Tts.TtsHeader ttsHeader = Tts.TtsHeader.newBuilder().setId(222).setCodec("PCM")
                .setDeclaimer("e2e").build();
        Tts.TtsRequest ttsRequest = Tts.TtsRequest.newBuilder().setHeader(ttsHeader).setText("我在唱歌").build();

        Iterator<Tts.TtsResponse> response = ttsServiceBlockingStub.tts(ttsRequest);


        System.err.println("finished");
    }

    public static void getAudio(String ip, int port, String codec, String lang, String text, int sampleRate) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(ip, port).usePlaintext(true).build();

        TtsServiceGrpc.TtsServiceStub ttsServiceStub = TtsServiceGrpc.newStub(channel);

        Tts.TtsHeader ttsHeader = Tts.TtsHeader.newBuilder().setId(new Random().nextInt(999999)).setCodec(codec).setSampleRate(sampleRate)
                .setDeclaimer(lang).build();
        Tts.TtsRequest ttsRequest = Tts.TtsRequest.newBuilder().setHeader(ttsHeader).setText(text).build();

        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final File outfile = new File(UUID.randomUUID().toString() + "." + codec);

        StreamObserver<Tts.TtsResponse> ttsResponseStreamObserver = new io.grpc.stub.StreamObserver<Tts.TtsResponse>() {
            public void onNext(Tts.TtsResponse ttsResponse) {
                System.err.println("onNext");
                try {
                    if (!outfile.exists()) {
                        outfile.createNewFile();
                    }
                    DataOutputStream fw = new DataOutputStream(new FileOutputStream(outfile, true));
                    fw.write(ttsResponse.getVoice().toByteArray());
                    fw.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onError(Throwable throwable) {
                System.err.println("onError");
                countDownLatch.countDown();
            }

            public void onCompleted() {
                System.err.println("onCompleted");
                countDownLatch.countDown();
            }
        };

        ttsServiceStub.tts(ttsRequest, ttsResponseStreamObserver);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        channel.shutdown();
        System.err.println("finished");
    }


    public static int asynGrpc(String ip, int port, String codec, String lang, String text, int sampleRate) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(ip, port).usePlaintext(true).build();

        TtsServiceGrpc.TtsServiceStub ttsServiceStub = TtsServiceGrpc.newStub(channel);

        Tts.TtsHeader ttsHeader = Tts.TtsHeader.newBuilder().setId(new Random().nextInt(999999)).setCodec(codec).setSampleRate(sampleRate)
                .setDeclaimer(lang).build();
        Tts.TtsRequest ttsRequest = Tts.TtsRequest.newBuilder().setHeader(ttsHeader).setText(text).build();

        CountDownLatch countDownLatch = new CountDownLatch(1);

        StreamObserverImpl<Tts.TtsResponse> streamObserver = new StreamObserverImpl<Tts.TtsResponse>();
        streamObserver.setCountDownLatch(countDownLatch);
        ttsServiceStub.tts(ttsRequest, streamObserver);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("finished: " + streamObserver.getStatus());
        channel.shutdown();
        return streamObserver.getStatus();
    }
}
