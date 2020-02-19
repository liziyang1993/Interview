package com.lzy;

public class Test {

    public int add(int x) {
        try {
            x++;
            return x;
        } finally {
            x++;
            return x;
        }
    }



    public static void main(String[] args) {
        System.out.println(new Test().add(1));
    }
}
