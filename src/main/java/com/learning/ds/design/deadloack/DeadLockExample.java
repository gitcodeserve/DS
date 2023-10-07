package com.learning.ds.design.deadloack;

public class DeadLockExample {
    private String resource1 = "RESOURCE1";
    private String resource2 = "RESOURCE2";

    public void thread1Work() {
        Thread t1 = new Thread(() -> {
            while(true){
                synchronized (resource1){
                    synchronized (resource2){
                        System.out.println(resource1 + resource2);
                    }
                }
            }

        });
        t1.start();
    }

    public void thread2Work() {
        Thread t1 = new Thread(() -> {
            while(true){
                synchronized (resource2){
                    synchronized (resource1){
                        System.out.println(resource1 + resource2);
                    }
                }
            }

        });
        t1.start();
    }

    public static void main(String[] args) {
        DeadLockExample deadLockExample = new DeadLockExample();
//        deadLockExample.thread1Work();
//        deadLockExample.thread2Work();
        String str = "Shantanu Sahay";
        char[] chars = str.toCharArray();
        for(char ch : chars) {
            System.out.print( ch + " -- ");
        }
    }
}
