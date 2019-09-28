package com.ethvi.interview.select;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/9/11 17:18
 */
public class Main {

    public static void main(String[] args) {
        int[] array = {1, 4, 6, 6, 6, 7, 8, 9};
        System.out.println("GetNumberOfK(array, x) = " + GetNumberOfK(array, 1));
    }

    public static int GetNumberOfK(int [] array , int k) {
        if(array.length == 0)
            return 0;
        int index = select(array, 0, array.length - 1, k);
        if(index == -1)
            return 0;
        int count = 1;
        int temp = index - 1;
        while(temp >= 0) {
            if(array[temp] == k)
                count++;
            else
                break;
            temp--;
        }
        temp = index + 1;
        while(temp <= array.length - 1) {
            if(array[temp] == k)
                count++;
            else
                break;
            temp++;
        }
        return count;
    }

    private static int select(int[] array, int left, int right, int key) {
        if (left > right || array[0] > key || array[right] < key)
            return -1;
        int mid = left + (right - left) * (key - array[left]) / (array[right] - array[left]);
        if (array[mid] < key)
            return select(array, mid, right, key);
        else if (array[mid] > key)
            return select(array, left, mid, key);
        else
            return mid;
    }
}
