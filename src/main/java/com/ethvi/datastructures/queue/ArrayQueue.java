package com.ethvi.datastructures.queue;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/7/29 20:28
 */
public class ArrayQueue {
    private int maxSize;  //队列的最大容量
    private int front;  //队列头
    private int rear;   //队列尾
    private int[] arr;  //该数组用于存放数据，模拟队列

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;  //指向队列头部
        rear = -1;   //指向队列的尾部
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addToQueue(int param) {
        if (isFull()) {
            System.out.println("队列满，无法添加");
            return;
        }
        rear++;
        arr[rear] = param;
    }

    public int getFromQueue() {
        if (isEmpty())
            throw new RuntimeException("队列为空，无法获取数据");
        front++;
        return arr[front];
    }

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("队列为空，无法获取数据");
        return arr[front + 1];
    }
}