package com.qinchy.springclouddemoprovider1.domain.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(2);

        new MyThread(latch).start();
        new MyThread(latch).start();

        System.out.println("等待 2 个子线程执行完毕...");
        latch.await();

        System.out.println("2 个子线程已经执行完毕");
        System.out.println("继续执行主线程");
    }
}

class MyThread extends Thread {
    private CountDownLatch latch;

    public MyThread(CountDownLatch latch) {
        super();
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
        latch.countDown();
    }
}
