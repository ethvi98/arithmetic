package com.ethvi.datastructures.linked;

import java.util.Stack;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/7/30 20:30
 */
public class SingleLinkdedList {

    private Node head = new Node(0, "", "");

    public Node getHead() {
        return head;
    }

    //反转单链表
    public void oversalList()
    {
        if (head.next == null)
            return;
        Node cur = head.next;
        Node newhead = new Node();
        while (cur != null) {
            Node next = cur.next;
            cur.next = newhead.next;
            newhead.next = cur;
            cur = next;
        }
        head = newhead;
    }

    public void add(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null)
                break;
            temp = temp.next;
        }
        temp.next = node;
    }

    public void addHead(Node node) {
        if (head.next != null)
            node.next = head.next;
        head.next = node;
    }

    public void addByOrder(Node node) {
        Node temp = this.head;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                break;
            }
            if (temp.next.no > node.no) {
                node.next = temp.next;
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    public void update(Node node) {
        Node temp = this.head;
        while (true) {
            if (temp.next.no == node.no) {
                node.next = temp.next.next;
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    public void delete(int no) {
        Node temp = this.head;
        while (true) {
            if (temp.next == null)
                throw new RuntimeException("notFoundSuchNodeException");
            if (temp.next.no == no) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            System.exit(0);
        }
        Node temp = head;
        while (true) {
            if (temp.next == null)
                break;
            System.out.println(temp.next.name);
            temp = temp.next;
        }
    }

    public void overlist() {
        if (head.next == null) {
            System.out.println("链表为空");
            System.exit(0);
        }
        Node temp = head.next;
        Stack<Node> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    class Node {
        public int no;
        public String name;
        public String nickname;
        private Node next;

        public Node(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        public Node(int no) {
            this.no = no;
        }

        public Node() {

        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }
}
