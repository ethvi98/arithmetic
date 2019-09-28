package com.ethvi.arithmetic.select;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/10 15:07
 */
public class BinarySelect {

    public static int select(int[] array, int target) {
        return work(0, array.length - 1, array, target);
    }

    public static List<Integer> selectList(int[] array, int target) {
        return workForList(0, array.length - 1, array, target);
    }

    private static int work(int i, int j, int[] array, int target) {
        if (i > j)
            return -1;
        int medium = (i + j) / 2;
        if (array[medium] == target)
            return medium;
        if (array[medium] > target)
            return work(i, medium - 1, array, target);
        else
            return work(medium + 1, j, array, target);
    }

    private static List<Integer> workForList(int i, int j, int[] array, int target) {
        int medium = (i + j) / 2;
        if (i > j)
            return null;
        if (array[medium] > target)
            return workForList(i, medium - 1, array, target);
        else if (array[medium] < target)
            return workForList(medium + 1, j, array, target);
        else {
            List<Integer> list = new ArrayList<>();
            list.add(medium);
            int left = medium - 1;
            int right = medium + 1;
            while (array[left] == target && left >= 0) {
                list.add(left);
                left--;
            }
            while (array[right] == target && right <= array.length-1) {
                list.add(right);
                right++;
            }
            return list;
        }

    }

}
