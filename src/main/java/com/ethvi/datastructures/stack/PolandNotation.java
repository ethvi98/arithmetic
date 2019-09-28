package com.ethvi.datastructures.stack;

import java.util.Stack;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/5 19:53
 */
public class PolandNotation {

    public static void main(String[] args) {
        String exp = "1 2 3 + 4 * + 5 -";
        System.out.println(calculateReversePolandNotation(exp));
    }

    public static int calculateReversePolandNotation(String exp) {
        Stack<String> stack = new Stack<>();
        String[] split = exp.split(" ");
        for (String s : split) {
            if (s.matches("\\d+")) {
                stack.push(s);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                if (s.equals("+")) {
                    System.out.println("+ = " + (s == "+"));
                    int i = num2 + num1;
                    stack.push("" + i);
                } else if (s.equals("-")) {
                    int i = num2 - num1;
                    stack.push("" + i);
                } else if (s.equals("*")) {
                    int i = num2 * num1;
                    stack.push("" + i);
                } else if (s.equals("/")) {
                    int i = num2 / num1;
                    stack.push("" + i);
                } else {
                    throw new RuntimeException("操作符有误 -> " + s);
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
