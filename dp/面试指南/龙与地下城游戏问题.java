package com.cheng.dp.面试指南;

import java.util.Scanner;

/**
 * T:给定一个二维数组map，含义是一张地图，例如：如下矩阵。
 * -2   -3    3
 * -5   -10   1
 * 0    30   -5
 * 游戏规则：
 * 骑士从左上角走到右下角，只能向下或者向右。
 * 每个位置的值表示要加减的血量
 * 其实走到任何一个位置，血量都不能少于1
 * 问：如果需要走到右下角，初始血量至少是多少。
 *
 *
 * @author nuonuo
 * @create 2021-04-12 19:33
 */
public class 龙与地下城游戏问题 {
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
        System.out.println(DungeonsAndDragonsGame(map, m, n));

    }

    /**
     * dp[i][j] 表示 走到map[i][j]至少需要多少血量，从右下角向上向左动态规划
     * 假设 map[2][2]=-5，则 dp[2][2]=6  至少要6才能走这个格子。
     * 如果map[2][2]=4正数，则dp[2][2]=1
     * dp[i][j]   1 - map[i][j]表示这个格子至少需要多少血量，map[i][j]如果是正数，就为1
     *   1 - map[i][j] + dp[i+1][j]表示这个格子向下走需要多少血量
     *   1 - map[i][j] + dp[i][j+1]表示这个格子向右走需要多少血量
     *
     *   选择较小的那个作为dp[i][j]
     */
    private static int DungeonsAndDragonsGame(int[][] map, int row, int col) {
        int[][] dp = new int[row][col];
        dp[row-1][col-1] = map[row-1][col-1] > 0 ? 1 : 1 - map[row-1][col-1];
        for (int i = row - 2; i >= 0; i--) {
            dp[i][col-1] = Math.max(dp[i+1][col-1] - map[i][col-1], 1);
        }
        for (int i = col - 2; i >= 0; i--) {
            dp[row-1][i] = Math.max(dp[row-1][i+1] - map[row-1][i], 1);
        }
        for (int i = row - 2; i >= 0;  i--) {
            for (int j = col - 2; j >= 0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i+1][j], dp[i][j+1]) - map[i][j], 1);
            }
        }
        return dp[0][0];
    }
}
