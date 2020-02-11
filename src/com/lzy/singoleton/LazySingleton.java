package com.lzy.singoleton;

import java.util.concurrent.TimeUnit;

public class LazySingleton {

    private static volatile LazySingleton instance;
    private LazySingleton(){};

    public synchronized static LazySingleton getInstance(){

        if (instance == null) {
            try {
                // 这里睡眠1秒是为了展现出实验的效果
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazySingleton();
        }


        return instance;
    }
    public static void main(String[] args){
        Thread threads[] = new Thread[10];
        for (int i = 0; i < 10; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    LazySingleton singleton = LazySingleton.getInstance();
                    System.out.println(Thread.currentThread().getName() + "  " +singleton.hashCode());
                }
            });
            threads[i].start();
        };
    }
}
