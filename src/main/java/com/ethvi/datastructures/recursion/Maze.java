package com.ethvi.datastructures.recursion;

/**
 * @Author ethvi
 * @Description:
 * @Date: 2019/8/5 22:00
 */
public class Maze {

    public static void main(String[] args) throws InterruptedException {
        int[][] maze = new int[10][10];
        initMaze(maze);

        maze[7][8] = 1;
        maze[8][7] = 1;
        System.out.println("原始的:");
        show(maze);
        getLast(maze, 1, 1);
        System.out.println("走完的");
        show(maze);
    }

    private static void initMaze(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            maze[maze.length-1][i] = 1;
            maze[0][i] = 1;
        }
        for (int i = 0; i < maze[0].length; i++) {
            maze[i][maze[0].length-1] = 1;
            maze[i][0] = 1;
        }
    }

    private static void show(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static boolean getLast(int[][] maze, int x, int y) throws InterruptedException {
        if (maze[maze.length - 2][maze[0].length - 2] == 2)
            return true;
        else {
            if (maze[x][y] == 0) {
                maze[x][y] = 2;
                show(maze);
                Thread.sleep(100);
                if (getLast(maze, x + 1, y))
                    return true;
                else if (getLast(maze, x, y + 1))
                    return true;
                else if (getLast(maze, x - 1, y))
                    return true;
                else if (getLast(maze, x, y - 1))
                    return true;
                else {
                    maze[x][y] = 3;
                    show(maze);
                    Thread.sleep(500);
                    return false;
                }
            } else
                return false;
        }
    }

}
