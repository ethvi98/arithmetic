package com.ethvi.arithmetic.LRU;


/**
 * @Author ethvi
 * @Description:  实现O(1)时间复杂度的LRU缓存机制
 *                思路：哈希表 + 双向链表
 * @Date: 2019/9/28 13:45
 */
public class LRUCache<K, V> {

    private Node[] table;

    //链表的的头节点
    private Node head;

    //链表的的尾节点
    private Node tail;

    //LRU的大小
    private int threshold;

    //LRU中当前元素数量
    private int size = 0;

    /**
     * 设置LRU的大小
     * @param capacity
     */
    public LRUCache(int capacity, float loadFactor) {
        table = new Node[(int) (capacity / loadFactor)];
        threshold = capacity;
        //创建头尾节点
        head = new Node(null);
        tail = new Node(null);
        //连接头尾节点
        head.next = tail;
        tail.pre = head;
    }

    public LRUCache(int capacity) {
        this(capacity, 0.75f);
    }


    public V get(K key) {
        //判断table中是否存在
        int index = module(key);
        if (table[index] == null) {
            return null;
        }
        //获取节点
        Node<K, V> node = table[index];
        while (node != null) {
            if (node.key == key)
                break;
            node = node.right;
        }
        if (node == null)
            return null;
        //将节点放到链表的第一个位置
        toFirst(node);
        return node.val;
    }

    private void toFirst(Node<K, V> node) {
        if (node.pre != null) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    public void put(K key, V value) {
        size++;
        //放入table
        int index = module(key);
        Node node = table[index];
        Node<K, V> n = new Node<>(key, value);
        if (node == null) {
            table[index] = n;
            //是否到达上限
            isThreshold();
            n.next = head.next;
            head.next.pre = n;
            head.next = n;
            n.pre = head;
            return;
        } else {
            while (node != null) {
                if (node.key == key) {
                    node.val = value;
                    break;
                }
                if (node.right == null) {
                    node.right = n;
                    n.left = node;
                    isThreshold();
                    node = n;
                    break;
                }
                node = node.right;
            }
        }
        //放入链表第一个位置
        toFirst(node);
    }

    private void isThreshold() {
        if (size > threshold) {
            size = threshold;
            Node<K, V> pre = tail.pre;
            pre.next.pre = pre.pre;
            pre.pre.next = pre.next;
            if (pre.left == null) {
                int module = module(pre.key);
                table[module] = pre.right;
                if (table[module] != null)
                    table[module].left = null;
                return;
            }
            pre.right.left = pre.left;
            pre.left.right = pre.right;
        }
    }

    //取模
    private int module(K k) {
        int i = k.hashCode();
        return i % table.length;
    }
    private static class Node<K, V> {
        K key;
        V val;
        Node pre;
        Node next;
        Node right;
        Node left;
        public Node(K key, Node pre) {
            this.key = key;
            this.pre = pre;
        }
        public Node(K key) {
            this.key = key;
        }
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
}
