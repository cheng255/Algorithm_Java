package com.cheng.面试金典;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nuonuo
 * @create 2021-08-07 12:02
 */
public class 迷路的机器人 {
    public static void main(String[] args) {
        pathWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}});
    }
    public static List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> res = new LinkedList<>();
        if(obstacleGrid == null || obstacleGrid.length == 0) {
            return res;
        }
        //首先将所有能走到的地方标记
        boolean[][] dp = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = true;
        }
        for (int j = 0; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = true;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                dp[i][j] = dp[i][j-1] || dp[i-1][j];
            }
        }
        //然后反向的去找路径
        if (!dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1]) {
            return res;
        }
        int i = obstacleGrid.length - 1, j = obstacleGrid[0].length - 1;
        while (i >= 0 && j >= 0) {
            List<Integer> list = new ArrayList<>();
            list.add(i); list.add(j);
            res.add(list);
            if (i > 0 && dp[i-1][j]) {
                i--;
            } else {
                j--;
            }
        }
        return res;

    }
}
