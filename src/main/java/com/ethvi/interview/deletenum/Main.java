package com.ethvi.interview.deletenum;

import java.util.*;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/24 23:28
 */
public class Main {

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random() * array.length / 3);
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
        //获取重复k次的元素
        List<Integer> elements = getElement(array, 3);
        //将数组的重复元素全部移至末端，并返回索引值
        int index = move(array, elements);
        //从0至index处的拷贝的新数组
        int[] result = Arrays.copyOfRange(array, 0, index);
        System.out.println("Arrays.toString(array) = " + Arrays.toString(result));
    }

    private static List<Integer> getElement(int[] array, int i) {
        Map<Integer, Integer> temp = new HashMap<>(array.length);
        for (int j = 0; j < array.length; j++) {
            if (null == temp.get(array[j]))
                temp.put(array[j], 1);
            else
                temp.put(array[j], temp.get(array[j]) + 1);
        }
        Iterator<Integer> iterator = temp.keySet().iterator();
        List<Integer> res = new ArrayList<>();
        Integer next = null;
        while (iterator.hasNext()) {
            next = iterator.next();
            if (temp.get(next).equals(i))
                res.add(next);
        }
        return res;
    }

    private static int move(int[] array, List<Integer> elements) {
        int index = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < elements.size(); j++)
                index = swap(array, i, index, elements.get(j));
        }
        return index;
    }

    private static int swap(int[] array, int i, int index, int ele) {
        int indx = index;
        //判断元素如果是集合中的数据则将其移动到末端
        if (array[i] == ele) {
            //转置前判断index位置的元素是否也是在elements数组中，若在，index--，重新判断
            if (ele == array[index])
                swap(array, array[i], --index, ele);
            else {
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
                indx = --index;
            }
        }
        return indx;
    }

}
