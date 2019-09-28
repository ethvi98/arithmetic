package com.ethvi.arithmetic.sort;

import java.util.Arrays;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/10 14:02
 */
public class Select {

    public static void work(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            int min = array[i];
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    minIndex = j;
                    min = array[j];
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[minIndex] = array[i];
                array[i] = min;
            }

        }
    }

}
