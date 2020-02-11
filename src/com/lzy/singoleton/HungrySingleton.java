package com.lzy.singoleton;

public class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return instance;
    }

    public static void main(String[] args){
        Thread threads[] = new Thread[10];
        for (int i = 0; i < 10; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    HungrySingleton singleton = HungrySingleton.getInstance();
                    System.out.println(Thread.currentThread().getName() + "  " +singleton.hashCode());
                }
            });
            threads[i].start();
        };
    }
}
