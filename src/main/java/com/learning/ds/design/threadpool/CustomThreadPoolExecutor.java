package com.learning.ds.design.threadpool;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*
Thread pool executor requires a Queue for holding tasks and a collection of Worker
Threads that will pick up tasks from the work queue start running them.
Let us try to write our own simple Thread Pool Executor implementation.
It is a typical Producer Consumer Problem statement.

https://www.javacodemonk.com/implement-custom-thread-pool-in-java-without-executor-framework-ca10e61d
 */
public class CustomThreadPoolExecutor {
    private BlockingQueue<Runnable> workerQueue;
    private Thread[] workerThreads;

    public CustomThreadPoolExecutor(int numberOfThread) {
        this.workerQueue = new LinkedBlockingQueue<>();
        workerThreads = new Thread[numberOfThread];
        int i = 0;
        for (Thread thread : workerThreads) {
            thread = new Worker("Custom Pool Thread " + ++i);
            thread.start();
        }
    }

    public void addTask(Runnable r) {
        try {
            workerQueue.put(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        public void run() {
            while (true) {
                System.out.println("Thread " + Thread.currentThread());
                try {
                    workerQueue.take().run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        CustomThreadPoolExecutor customThreadPoolExecutor = new CustomThreadPoolExecutor(5);
        customThreadPoolExecutor.addTask(() -> System.out.println("First print task"));
        customThreadPoolExecutor.addTask(() -> System.out.println("Second print task"));
    }
}