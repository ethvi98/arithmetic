package com.ethvi.datastructures.queue;

/**
 * @Author ethvi
 * @Description: 用数组实现环形链表
 * @Date: 2019/7/29 20:28
 */
public class CircleArrayQueue {
    private int maxSize;  //队列的最大容量
    private int front;  //队列头
    private int rear;   //队列尾
    private int[] arr;  //该数组用于存放数据，模拟队列

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize ;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return front  == (rear + 1) % maxSize;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addToQueue(int param) {
        if (isFull()) {
            System.out.println("队列满，无法添加");
            return;
        }
        arr[rear] = param;
        rear = (rear + 1) % maxSize;
    }

    public int getFromQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法获取数据");
        }
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("队列为空，无法获取数据");
        return arr[front + 1];
    }
//    //以maxSize = 4做测试
//    public void show() {
//        System.out.println( "arr[0] = " + arr[0]) ;
//        System.out.println( "arr[1] = " + arr[1]) ;
//        System.out.println( "arr[2] = " + arr[2]) ;
//        System.out.println( "arr[3] = " + arr[3]) ;
//    }
}

