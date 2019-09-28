package com.ethvi.interview.testfor58;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/9/21 19:58
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int next = scanner.nextInt();
        String[] str = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "`", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "{", "}", "\\", "<", ">;", "?"};
        Stack<Integer> stack = new Stack<>();
        while (next >= 27) {
            int i = next % 27;
            stack.push(i);
            next = next / 27;
        }
        stack.push(next);
        String res = "";
        while (!stack.isEmpty()) {
            res += str[stack.pop()];
        }
        System.out.println(res);
//
//        Scanner scanner = new Scanner(System.in);
//        String next = scanner.next();
//        StringBuilder str = new StringBuilder(next);
//        Node node = new Node('M');
//        Node node2 = new Node('A');
//        Node node3 = new Node('S');
//        Node node4 = new Node('K');
//        node.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node;
//        Node temp = node;
//        for (int i = 1; i < next.length(); i = i+2) {
//            if (next.charAt(i) == '@')
//                break;
//            char sub = next.charAt(i);
//            str.insert(i, temp.val);
//            temp = temp.next;
//        }
//        System.out.println(str);
    }
//
//    public static class Node {
//        char val;
//        Node next;
//        public Node(char a) {
//            val = a;
//        }
//    }

}