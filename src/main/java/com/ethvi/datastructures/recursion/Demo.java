package com.ethvi.datastructures.recursion;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/5 21:20
 */
public class Demo {
    public static void main(String[] args) {
        test(9);
    }

    public static void test(int n) {
        System.out.println(n);
        if (n > 2)
            test(n - 1);
        System.out.println(n);
    }
}
