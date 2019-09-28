package com.ethvi.interview.get1$3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/24 10:19
 */
public class Main {

    public static void main(String[] args) {
//        int[] array = new int[10];
//        for (int i = 0; i < array.length; i++)
//            array[i] = (int) (Math.random() * array.length / 5);
        int[] array = {10, 3, 1, 3, 3, 3, 3, 3, 3, 6, 3, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6};
        List<Integer> result = getList(array);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + "  ");
        }
    }

    private static List<Integer> getList(int[] array) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(128);
        for (int i = 0; i < array.length; i++) {
            if (null == map.get(array[i]))
                map.put(array[i], 1);
            else
                map.put(array[i], map.get(array[i]) + 1);
        }
        List<Integer> result = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer val = next.getValue();
            if (val > array.length / 2)
                result.add(next.getKey());
        }
        return result;
    }

}
