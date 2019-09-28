package com.ethvi.arithmetic.sort;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/10 12:59
 */
public class Maopao {

    public static void work(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j -1] > array[j]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }

    public static void betterWork(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int flag = 0;
            for (int j = 1; j < array.length; j++) {
                if (array[j -1] > array[j]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    flag++;
                }
            }
            if (flag == 0)
                break;
        }
    }

}
