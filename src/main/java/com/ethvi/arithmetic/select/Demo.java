package com.ethvi.arithmetic.select;

import com.ethvi.arithmetic.sort.Select;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/10 15:33
 */
public class Demo {
    static int[] array = new int[100];

    static {
        for (int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random() * (array.length / 10));
    }

    public static void print() {
        Arrays.stream(array).forEach(x -> System.out.print(x + "   "));
    }

    @Test
    public void binaryDemo() {
        Select.work(array);
        print();
        int[] arr = new int[]{11, 13, 15, 17, 23, 67, 89, 96, 100, 100, 103};
        int index = BinarySelect.select(arr, 10);
        System.out.println("\n index = " + index);
//        List<Integer> list = BinarySelect.selectList(array, 2);
//        System.out.println("list size = " + list.size());
//        list.forEach(x -> System.out.print(x + "  "));
    }

    @Test
    public void insertDemo() {
        int[] arr = new int[]{11, 13, 15, 17, 23, 67, 89, 89, 89,89, 89,89, 89,89, 89, 96, 100, 100, 103};
        int index = InsertSelect.select(arr, 89);
        System.out.println("\n index = " + index);
    }
}
