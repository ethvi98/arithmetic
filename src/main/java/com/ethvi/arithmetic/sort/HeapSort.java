package com.ethvi.arithmetic.sort;

import java.util.Arrays;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/22 19:18
 */
public class HeapSort {

    public static void main(String[] args) {
//        int[] arr = {4, 9, 6, 8, 5};
        int[] arr = new int[10000000];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * arr.length * 10);
        long s = System.currentTimeMillis();
        heapSort(arr);
        long e = System.currentTimeMillis();
        System.out.println("(e - s) = " + (e - s) + " ms");
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        int temp = 0;
      //建堆
        for (int i  = arr.length / 2 - 1; i >= 0; i--) {
            build(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            //交换
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //维护堆
            build(arr, 0, i);
        }
    }


    private static void build(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            if (j + 1 < length && arr[j] < arr[j+1])
                j++;
            if (arr[j] < temp)
                break;
            else {
                //将子节点赋给此节点
                arr[i] = arr[j];
                i = j;
            }
        }
        arr[i] = temp;
    }


}
