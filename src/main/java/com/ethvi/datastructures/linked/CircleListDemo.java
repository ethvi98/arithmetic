package com.ethvi.datastructures.linked;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/3 21:19
 */
public class CircleListDemo {
    public static void main(String[] args) {
        CircleList<Integer> cl = new CircleList<>();
        Integer[] x = new Integer[41];
        IntStream.rangeClosed(1,x.length).forEach(xx -> {
            x[xx-1] = xx;
        });
        cl.add(x);
//        cl.print();
        Object[] josephu = cl.josephu(3, x.length);
        Arrays.asList(josephu).stream().forEach(System.out::println);
    }

}
