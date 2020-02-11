package com.lzy.singoleton;

import java.util.concurrent.TimeUnit;

public class ConcurrentLazySingleton {

    private static volatile ConcurrentLazySingleton instance;

    private ConcurrentLazySingleton() {
    }

    public static ConcurrentLazySingleton getInstance() {

        if (instance == null) {
            try {
                // 这里睡眠1秒是为了展现出实验的效果
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (ConcurrentLazySingleton.class) {
                if (instance == null) {
                    instance = new ConcurrentLazySingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Thread threads[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    ConcurrentLazySingleton singleton = ConcurrentLazySingleton.getInstance();
                    System.out.println(Thread.currentThread().getName() + "  " + singleton.hashCode());
                }
            });
            threads[i].start();
        }
        ;
    }
}
