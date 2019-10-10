package com.wj.mail.api.utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: springLearnDemo <br>
 * @Description: 并发工具测试工具类 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-10-10 18:02
 **/
public class CountDownLatchUtil {
    private CountDownLatch start;

    private CountDownLatch end;

    private int pollSize = 10;

    public CountDownLatchUtil() {
        this(10);
    }

    public CountDownLatchUtil(int pollSize) {
        this.pollSize = pollSize;
        start = new CountDownLatch(1);
        end = new CountDownLatch(pollSize);
    }

    public void latch(MyFunctionInterface functionInterface) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(pollSize);
        for (int i = 0; i < pollSize; i++) {
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        start.await();
                        functionInterface.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                }
            };
            executorService.submit(run);
        }
        start.countDown();
        end.await();
        executorService.shutdown();

    }

    @FunctionalInterface
    public interface MyFunctionInterface {
        void run();
    }
}
