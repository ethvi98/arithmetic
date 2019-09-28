package com.ethvi.datastructures.stack;

import java.util.Stack;

/**
 * @Author ethvi
 * @Description:使用栈实现加减乘除，可以多位数
 * @Date: 2019/8/4 12:17
 */

public class Calculate {

    private static Stack<Integer> num = new Stack<>();
    private static Stack<Character> ope = new Stack<>();

    public static Integer go(String exp) {
        //用于遍历字符串
        int temp = 0;
        while (temp < exp.length()) {
            char c = exp.charAt(temp);
            // 小于0表示是数字，push到数值栈中即可
            // 因为需要实现多位数，所以需要使用递归判断并获取下一位数字
            if (getPriority(c) < 0) {
                // 用一个栈存储获取到的多位数，和temp的值（如果不返回最终的temp值，
                // 虽然获取到多位数，但temp还会停留在多位数第二位所在位置）
                Stack<Integer> res = getNum(exp, temp, String.valueOf(c));
                // 将获取的多位数压入数值栈
                num.push(res.pop());
               // 刷新temp的位置
                temp = res.pop();
            } else  // 大于0说明是运算符，压入运算符栈
                push(c);
            temp++;
        }
        //计算最终栈中的数据
        return result(num, ope);
    }

    //最后数据栈中的数据求结果
    private static Integer result(Stack<Integer> num, Stack<Character> ope) {
        while (num.size() > 1) {
            setResult();
        }
        return num.pop();
    }

    //获取运算符的优先级，还可以用于判断是否是数值还是运算符
    private static int getPriority(char x) {
        if (x == '+')
            return 1;
        if (x == '-')
            return 2;
        if (x == '*' || x == '/')
            return 3;
        return -1;
    }

    //将运算符压入运算符栈需要考虑优先级的问题
    private static void push(char x) {
        if (ope.size() == 0 || getPriority(ope.peek()) <= getPriority(x)) {
            ope.push(x);
            return;
        }
        setResult();
        push(x);
    }

    private static void setResult() {
        switch (ope.pop()) {
            case '+':
                num.push(num.pop() + num.pop());
                break;
            case '-':
                num.push(-num.pop() + num.pop());
                break;
            case '*':
                num.push(num.pop() * num.pop());
                break;
            case '/':
                int a = num.pop();
                int b = num.pop();
                int c = b / a;
                num.push(c);
                break;
        }
    }
    //递归获取多位数
    private static Stack<Integer> getNum(String exp, int x, String res) {
        if ((x + 1) >= exp.length() || getPriority(exp.charAt(x + 1)) > 0) {
            Stack<Integer> result = new Stack<>();
            result.push(x);
            result.push(Integer.parseInt(res));
            return result;
        }
        res = res + exp.charAt(++x);
        return getNum(exp, x, res);
    }
}
