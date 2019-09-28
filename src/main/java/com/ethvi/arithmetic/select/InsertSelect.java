package com.ethvi.arithmetic.select;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/11 13:23
 */
public class InsertSelect {

    public static int select(int[] array, int key) {
        return work(array, 0, array.length - 1, key);
    }

    private static int work(int[] array, int left, int right, int key) {
        System.out.println("work ~");
        if (left > right || array[0] > key || array[right] < key)
            return -1;
        int mid = left + (right - left) * (key - array[left]) / (array[right] - array[left]);
        if (array[mid] < key) {
            return work(array, mid, right, key);
        } else if (array[mid] > key)
            return work(array, left, mid, key);
        else
            return mid;
    }

}
