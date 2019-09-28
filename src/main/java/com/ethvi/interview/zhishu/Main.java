package com.ethvi.interview.zhishu;

/**
 * @Author ethvi
 * @Description: 求一千以内的素数
 * @Date: 2019/8/29 10:56
 */
public class Main {
    public static void main(String[] args) {
        int n = getNum(1000);
        System.out.println("\n 素数总数为 " + n + " 个");
    }

    private static int getNum(int i) {
        int n = 0;
        System.out.print("2 ");
        for (int j = 3; j <= i; j++) {
            boolean a = false;
            A : for (int k = 2; k <= (int) Math.sqrt(j) + 1; k++) {
                if (j % k == 0) {
                    a = true;
                    break A;
                }
            }
            if (!a) {
                System.out.print("," + j + " ");
                n++;
            }
        }
        return 1 + n;
    }
}
