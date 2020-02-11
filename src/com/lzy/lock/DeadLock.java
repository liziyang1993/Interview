package com.lzy.lock;

import java.util.concurrent.TimeUnit;
/**
 * 两个线程产生死锁问题，程序启动后无法停止，两个线程均处于阻塞状态
 * */
public class DeadLock {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void testDeadLock(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1 start ......");
                synchronized (lock1){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2){
                        System.out.println("Thread1 finished!");
                    }

                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread2 start ......");
                synchronized (lock2){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1){
                        System.out.println("Thread2 finished!");
                    }

                }
            }
        });
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args){
        new DeadLock().testDeadLock();
    }
}
