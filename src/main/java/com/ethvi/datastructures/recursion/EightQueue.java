package com.ethvi.datastructures.recursion;

/**
 * @Author ethvi
 * @Description: 八皇后问题
 * @Date: 2019/8/7 18:43
 */
public class EightQueue {

    private int[] queue;

    public EightQueue(int num) {
        this.queue = new int[num];
    }

    public static void main(String[] args) {
        EightQueue eightQueue = new EightQueue(8);
        eightQueue.put(0);
    }

    public void print() {
        for (int i = 0; i < queue.length; i++) {
            System.out.print(queue[i] + "   ");
        }
        System.out.println();
    }

    //判断与所放的皇后是否冲突
    private boolean judge(int i) {
        for (int j = 0; j < i; j++) {
            if (queue[j] == queue[i] || Math.abs(i - j) == Math.abs(queue[i] - queue[j]))
                return false;
        }
        return true;
    }

    private void put(int i) {
        if (i == queue.length) {
            print();
            return;
        }
        for (int j = 0; j < queue.length; j++) {
            queue[i] = j;
            if (judge(i))
                put(i + 1);
        }
    }

}
