package com.ethvi.datastructures.linked;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/3 19:24
 */
public class CircleList<T> {

    private Enity head = new Enity();

    public void add(T[] list) {
        if (list.length == 0)
            return;
        Enity temp = head;
        for (int i = 0; i < list.length; i++) {
            Enity e = new Enity(list[i]);
//            e.next = temp;
//            temp.next = e;
            temp.next = e;
            temp = temp.next;
        }
        temp.next = head.next;
    }
    public void print() {
        Enity e = head;
        while (e.next != null) {
            System.out.println(e.next.name);
            e = e.next;
        }
    }

    public Object[] josephu(int m, int n) {
        Object[] o = new Object[n];
        Enity e = head;
        int temp = 0, x = 0;
        while (e.next != e){
            if (temp == m - 1) {
                o[x++] = e.next.name;
                temp = 0;
                e.next = e.next.next;
            }
            e = e.next;
            temp ++;
        }
        o[x] = e.name;
        return  o;
    }

    private class Enity {
        Enity next;
        T name;

        public Enity(T name) {
            this.name = name;
        }
        public Enity() {
        }
    }
    Stack s = new Stack();
}

