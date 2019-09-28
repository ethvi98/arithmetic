package com.ethvi.interview.array;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/23 19:24
 */
public class Main {

    public static void main(String[] args) {
        int[][] array = new int[10][10];
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = ++k;
            }
        }
        print(array);
        System.out.println("\n\n\n");
        circlePrint(array);

    }

    private static void circlePrint(int[][] array) {
        int b = array.length;
        int r = array.length;
        int l = 0;
        int t = 0;
        int n = b * r;
        while (n > 0) {
            //往右打印
            for (int i = l; i < r; i++) {
                System.out.print(array[t][i] + "  ");
                n--;
            }
            t++;
            //往下打印
            for (int i = t; i < b; i++) {
                System.out.print(array[i][r - 1] + "  ");
                n--;
            }
            r--;
            //往左打印
            for (int i = r; i > l; i--) {
                System.out.print(array[b - 1][i - 1] + "  ");
                n--;
            }
            b--;
            //往上打印
            for (int i = b; i > t; i--) {
                System.out.print(array[i - 1][l] + "  ");
                n--;
            }
            l++;
        }
    }


    public static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("   %d   ", array[i][j]);
            }
            System.out.println();
        }
    }


}
