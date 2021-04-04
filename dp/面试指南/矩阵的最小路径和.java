package com.cheng.dp.面试指南;

import java.util.Scanner;

/**
 * T:给定一个矩阵m，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，
 * 路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 *
 * 详情看书
 *
 * @author nuonuo
 * @create 2021-04-01 18:51
 */
public class 矩阵的最小路径和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        System.out.println(minPathSum1(map));
        System.out.println(minPathSum(map));
    }

    //思路：dp[i][j]表示走到ij位置最小和，dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])
    //这里改成空间复杂度 O(min(M,N))的
    private static int minPathSum1(int[][] map) {
        if (map == null || map.length == 0 || map[0] == null || map[0].length == 0) {
            return 0;
        }
        int more = Math.max(map.length, map[0].length);
        int less = Math.min(map.length, map[0].length);
        boolean rowIsBigger = map.length == more;//表示行是否更大
        int[] dp = new int[less];
        dp[0] = map[0][0];
        for (int i = 1; i < less; i++) {
            dp[i] = dp[i - 1] + (rowIsBigger ? map[0][i] : map[i][0]);
        }
        for (int i = 1; i < more; i++) {
            dp[0] = dp[0] + (rowIsBigger ? map[i][0] : map[0][i]);
            for (int j = 1; j < less; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + (rowIsBigger ? map[i][j] : map[j][i]);
            }
        }
        return dp[less - 1];
    }

    //思路：dp[i][j]表示走到ij位置最小和，dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])
    private static int minPathSum(int[][] map) {
        int[][] dp = new int[map.length][map[0].length];
        dp[0][0] = map[0][0];
        for (int i = 1; i < map[0].length; i++) {//第一行
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }
        for (int i = 1; i < map.length; i++) {//第一列
            dp[i][0] = dp[i - 1][0] + map[i][0];
        }
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
            }
        }
        return dp[map.length - 1][map[0].length - 1];
    }
}
