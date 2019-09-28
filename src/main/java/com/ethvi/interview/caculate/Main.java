package com.ethvi.interview.caculate;

import java.util.Scanner;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/27 15:45
 */
public class Main {

    public static void main(String[] args) {
        //将一个数不进行加减乘除扩大十五倍
//        System.out.println("请输入一个整数:");
//        Scanner sc = new Scanner(System.in);
//        int var = sc.nextInt();
//        System.out.println(add(var << 4, -var));

        /**
         * 15       -->   00001111
         * 15 << 3  -->   01111000
         *  ^       -->   01110111   55
         *  &       -->   00001000
         */

        System.out.println("add(15,15) = " + add(15<<4, -15));
    }

    private static int add(int a, int b) {
        int sum, and;
        do {
            sum = a ^ b;
            and = (a & b) << 1;
            a = sum;
            b = and;
        } while (b != 0);
        return a;
    }

    private static int multiply(int num, int mul) {
        int i = 1;
        int m = mul;
        while (m >> 1 != 0) {
            i <<= 1;
            m >>= 1;
        }
        int add = i;
        int result = 0;
        while (add != 0) {
            result = add(num << add, result);
            add >>= 1;
        }
        return result;
    }

}
