package com.ethvi.datastructures.stack;


/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/4 11:55
 */
public class StackDemo {

    public static void main(String[] args) {
        String exp = "777*333+999-888/24+222";
        System.out.println("result = " + Calculate.go(exp));
        System.out.println("real result = " + (777*333+999-888/24+222));

    }

}
