package com.learning.ds.design.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
    private Queue<T> queue = new LinkedList<>();
    Lock lock = new ReentrantLock();
    private Condition notFill = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void put(T element) throws InterruptedException {
        lock.lock();
        try {
            if (queue.size() == capacity) {
                notFill.await();
            }
            queue.add(element);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            if (queue.isEmpty()){
               notEmpty.await();
            }
            T element = queue.remove();
            notFill.signal();
            return element;
        } finally {
            lock.unlock();
        }
    }

}
