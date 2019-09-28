package com.ethvi;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @Author ethvi
 * @Description:  在一万个数中查找前100的（面试题）   时间复杂度   O(N)
 * @Date: 2019/8/16 16:24
 */
public class TopK {

    public static void main(String[] args) {
//        try { TimeUnit.SECONDS.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
        int[] array = new int[1000000000];
        for (int i = 0; i < array.length; i++)
            array[i] = (int)(Math.random()*1000000000);
        //冒泡排序
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array.length-1; j++) {
//                if (array[j + 1] < array[j]) {
//                    int temp = array[j + 1];
//                    array[j +  1] = array[j];
//                    array[j] = temp;
//                }
//            }
//        }

        long start = System.currentTimeMillis();
        A a = new A(array, 10000);
        int[] go = a.go();
        long end = System.currentTimeMillis();

//        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(go));
        System.out.println("(end - start) = " + (end - start) + "ms");
    }


}
class A {
    private int[] ar;
    private int num;
    private int[] temp;
    public A(int[] r, int n) {
        ar = r;
        num = n;
        temp = new int[num];
    }

    public int[] go() {
        int maxIndex = 0;
        temp = Arrays.copyOfRange(ar, 0, num);
        maxIndex = setMaxIndex();
        for (int i = num; i < ar.length; i++) {
            if (ar[i] < temp[maxIndex]) {
                temp[maxIndex] = ar[i];
                maxIndex = setMaxIndex();
            }
        }
        return temp;
    }

    public int setMaxIndex() {
        int maxIndex = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > temp[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }
}