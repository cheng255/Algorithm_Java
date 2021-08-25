package com.cheng.dfs;

/**
 * 思路：计算每个位置能走多远
 * @author nuonuo
 * @create 2021-08-25 11:35
 */
public class 矩阵中的最长递增路径 {
    public void main(String[] args) {
        int[][] arr = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        int[][] arr1 = new int[][]{
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                {19, 18, 17, 16, 15, 14, 13, 12, 11, 10},
                {20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
                {39, 38, 37, 36, 35, 34, 33, 32, 31, 30},
                {40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
                {59, 58, 57, 56, 55, 54, 53, 52, 51, 50},
                {60, 61, 62, 63, 64, 65, 66, 67, 68, 69},
                {79, 78, 77, 76, 75, 74, 73, 72, 71, 70},
                {80, 81, 82, 83, 84, 85, 86, 87, 88, 89},
                {99, 98, 97, 96, 95, 94, 93, 92, 91, 90},
                {100, 101, 102, 103, 104, 105, 106, 107, 108, 109},
                {119, 118, 117, 116, 115, 114, 113, 112, 111, 110},
                {120, 121, 122, 123, 124, 125, 126, 127, 128, 129},
                {139, 138, 137, 136, 135, 134, 133, 132, 131, 130},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(longestIncreasingPath(arr1));
    }

    int[][] temp = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        int m = matrix.length; int n = matrix[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, func(matrix, m, n, memo, i, j));
            }
        }
        return res;
    }
    public int func(int[][] matrix, int m, int n, int[][] memo, int i, int j) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int k = 0;
        memo[i][j]++;
        while (k < temp.length) {
            int newI = i + temp[k][0];
            int newJ = j + temp[k][1];
            k++;
            if (newI >= m || newI < 0 || newJ >= n || newJ < 0) continue;
            if (matrix[newI][newJ] > matrix[i][j]) {
                memo[i][j] = Math.max(memo[i][j], func(matrix, m, n, memo, newI, newJ) + 1);
            }
        }
        return memo[i][j];
    }
}
