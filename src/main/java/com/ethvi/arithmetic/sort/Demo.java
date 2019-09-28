package com.ethvi.arithmetic.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/10 13:01
 */
public class Demo {
    static int[] array = new int[100000];
    static {
        for (int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random()*array.length*10);
    }

    public static void print() {
        Arrays.stream(array).forEach(x -> System.out.print(x + "   "));
    }

    @Test
    public void maopaoDemo() {
        long start = System.currentTimeMillis();
        Maopao.work(array);
        long end = System.currentTimeMillis();
        System.out.println("work time = " + (end - start) + " ms");
        print();
        System.out.println("\n\n");
        long start1 = System.currentTimeMillis();
        Maopao.betterWork(array);
        long end1 = System.currentTimeMillis();
        System.out.println("better work time = " + (end1 - start1) + " ms");
        print();
    }

    @Test
    public void selectDemo() {
        int[] arr = new int[]{6,2,7,1,8,9,11,23,4};
        Select.work(array);
        print();
    }

//
//    class Person {
//        int id;
//        String name;
//        public Person(int id, String name) {
//            this.id = id;
//            this.name = name;
//        }
//    }
}
