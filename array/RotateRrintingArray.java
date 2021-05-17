package com.cheng.array;

import java.util.Arrays;

/**
 * 旋转打印数组
 * @author nuonuo
 * @create 2021-03-23 17:10
 */
public class RotateRrintingArray {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2}, {3,4}};
        System.out.println(Arrays.toString(clockwisePrint(arr, 2, 2)));
    }
    public static int[] clockwisePrint(int[][] mat, int n, int m) {
        int[] res = new int[n*m];
        int index = 0;
        // write code here
        int r = 0; int c = 0;
        while (r < n || c < m) {
            for (int i = r; i < n; i++) {
                res[index++] = mat[i][c];
            }
            c++;
            for (int i = c; i < m; i++) {
                res[index++] = mat[n - 1][i];
            }
            n--;
            for (int i = n - 1; i >= r; i--) {
                res[index++] = mat[i][m - 1];
            }
            m--;
            for (int i = m - 1; i >= c; i--) {
                res[index++] = mat[r][i];
            }
            r++;
        }
        return res;
    }
}
