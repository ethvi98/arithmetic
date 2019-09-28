package com.ethvi.interview.arrayzz;

import java.util.Arrays;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/28 19:43
 */
public class Main {

    public static void main(String[] args) {
        int[][] array = new int[1000][1000];
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = ++k;
            }
        }
        int temp;
        for (int i = 0; i < array[0].length; i++) {
            for (int j = i; j < array.length; j++) {
                temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length / 2; j++) {
                temp = array[i][j];
                array[i][j] = array[i][array[i].length - 1 - j];
                array[i][array[i].length - 1 - j] = temp;
            }
        }
        print(array);
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
