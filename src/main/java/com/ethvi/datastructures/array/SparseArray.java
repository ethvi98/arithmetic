package com.ethvi.datastructures.array;

import java.util.Arrays;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/7/28 20:08
 */
public class SparseArray {

    public static void main(String[] args) {
        //创建一个11*11的二位数组
        //0表示没有棋子，1表示黑子，2表示蓝子
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
//        for (int i = 0; i < chessArray.length; i++) {
//            System.out.println(chessArray[i]);
//        }
        Arrays.stream(chessArray).forEach(x -> {
            Arrays.stream(x).forEach(y -> {
                System.out.print(y + "  ");
            });
            System.out.println();
        });

        int sum = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[0].length; j++) {
                if (chessArray[i][j] != 0)
                    sum++;
            }
        }
        System.out.println(chessArray.length);
        System.out.println("sum = " + sum);

        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = 2;
        int count  = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[0].length; j++) {
                if (chessArray[i][j] != 0) {
                    sparseArray[++count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }
            }
        }

        System.out.println("-----------------------------------------------------");
        Arrays.stream(sparseArray).forEach(x -> {
            Arrays.stream(x).forEach(y -> {
                System.out.print("   " + y);
            });
            System.out.println();
        });


        System.out.println("------------------还原稀疏数组-----------------------");

        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
                chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        Arrays.stream(chessArray2).forEach(x -> {
            Arrays.stream(x).forEach(y -> {
                System.out.print(y + "  ");
            });
            System.out.println();
        });
    }

}
