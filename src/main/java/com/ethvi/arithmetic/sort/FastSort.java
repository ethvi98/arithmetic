package com.ethvi.arithmetic.sort;

import java.util.Arrays;

/**
 * @Author ethvi
 * @Description: 快速排序  优化过的
 * @Date: 2019/8/20 19:40
 */
public class FastSort {

    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random() * array.length * 10);
//        Arrays.sort(array);
//        int[] array = new int[]{1, 3, 5, 6, 3};
        long start = System.currentTimeMillis();
        quick_sort_self(array, 0, array.length - 1);
//        Arrays.sort(array);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " ms");
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
    }


    //快速排序
    public static void quick_sort(int s[], int l, int r) {
        if (l < r) {
            //将中间的这个数和第一个数交换
            int random = (int) (l + Math.random() * (r - l + 1));
            int temp = s[l];
            s[l] = s[random];
            s[random] = temp;
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j)
                    s[i++] = s[j];
                while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }


    // 自己写的
    public static void quick_sort_self(int[] arr, int start, int end) {
        if (start < end) {
            //将第一个与数组中随机位置的元素交换
            int v = start + (int) ((end - start) * Math.random());
            swap(arr, start, v);
            //创建两个指针，和一个标志
            int left = start, right = end, x = arr[start];
            while (left < right) {
                //交换
                if (arr[left] > x && arr[right] < x) {
                    swap(arr, left, right);
                    left++;
                    right--;
                }
                //从右边往左找比第一个小的
                while (left < right && arr[right] >= x)
                    right--;
                //从左边往右找比第一个大的
                while (left < right && arr[left] <= x)
                    left++;
            }
            //将left位置的和start交换
            if (arr[start] < arr[left])
                left--;
            swap(arr, start, left);
            // 从start 到 left - 1 继续
            quick_sort_self(arr, start, left - 1);
            // 从left + 1 到 end继续
            quick_sort_self(arr, left + 1, end);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
