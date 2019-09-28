package com.ethvi.datastructures.queue;

/**
 * @Author ethvi
 * @Description: 使用数组模拟队列
 * @Date: 2019/7/28 21:14
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue circle = new CircleArrayQueue(4);
        circle.addToQueue(2);
        circle.addToQueue(4);
        System.out.println(circle.getFromQueue());
        System.out.println(circle.getFromQueue());
//        System.out.println(circle.getFromQueue());
//        circle.addToQueue(7);
//        circle.addToQueue(9);
//        circle.addToQueue(19);
//        circle.show();
    }
}


