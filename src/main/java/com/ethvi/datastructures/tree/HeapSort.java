package com.ethvi.datastructures.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/18 12:28
 */
public class HeapSort {

    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        /**
         *               1
         *         26          6
         *     3       9    2
         */
        int[] arr = new int[10000000];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * arr.length * 10);
        long start = System.currentTimeMillis();
        heap_sort_self(arr);    //耗时  3355 ms
//        MinHeap_Sort(arr, arr.length); //耗时  3334 ms
        long end = System.currentTimeMillis();
        System.out.println("\n耗时  " + (end - start) + " ms");
//        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

    }


    public static void heap_sort_self(int[] arr) {
        //建堆
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            adjust(arr, i, arr.length);
        //将第一个节点调节至数组末端，并维护第一个节点
        int temp;
        for (int i = arr.length - 1; i >= 0 ; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjust(arr, 0, i);
        }
    }

    /**
     * 调节指定节点
     * @param arr 数组
     * @param i  要调节的节点的索引值
     * @param length  调节的范围
     */
    public static void adjust(int[] arr, int i, int length) {
        //存储要调节的节点
        int temp = arr[i];
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            if (j + 1 < length && arr[j] < arr[j+1])
                j++;
            if (arr[j] > temp) {
                //将较大的子节点赋给当前节点
                arr[i] = arr[j];
                //继续调整子节点
                i = j;
            } else  //当前节点所在堆已经是顶对了，不需要调整直接返回
                break;
        }
        //最后停留的节点
        arr[i] = temp;
    }


//
//    public static void heapSort1(int[] arr) {
//        buildHeap(arr, 0, arr.length - 1);
//        for (int i = arr.length - 1; i >= 0; i--) {
//            swap(arr, i);
//            buildHeap(arr, 0, i - 1);
//        }
//    }
//
//    private static void swap(int[] arr, int index) {
//        int temp = arr[0];
//        arr[0] = arr[index];
//        arr[index] = temp;
//    }
//
//    private static void buildHeap(int[] arr, int start, int end) {
//        for (int i = (end - 1) >> 1; i >= start; i--) {
//            int left = (i << 1) + 1;
//            int right = (i << 1) + 2;
//
//            if ((right <= end) && (arr[right] > arr[left]) && (arr[right] > arr[i])) {
//                int temp = arr[i];
//                arr[i] = arr[right];
//                arr[right] = temp;
//            }
//            else if (arr[left] > arr[i]) {
//                int temp = arr[i];
//                arr[i] = arr[left];
//                arr[left] = temp;
//            }
//        }
//    }


    public static void MinHeap_Sort(int a[], int n) {
        int temp = 0;
        MakeMinHeap(a, n);
        for (int i = n - 1; i > 0; i--) {
            temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            MinHeapFixdown(a, 0, i);
        }
    }

    //构建最小堆
    public static void MakeMinHeap(int a[], int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            MinHeapFixdown(a, i, n);
        }
    }

    //从i节点开始调整,n为节点总数 从0开始计算 i节点的子节点为 2*i+1, 2*i+2
    public static void MinHeapFixdown(int a[], int i, int n) {

        int j = 2 * i + 1; //子节点
        int temp = 0;

        while (j < n) {
            //在左右子节点中寻找最小的
            if (j + 1 < n && a[j + 1] < a[j]) {
                j++;
            }
            if (a[i] <= a[j])
                break;
            //较大节点下移
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i = j;
            j = 2 * i + 1;
        }
    }



}
