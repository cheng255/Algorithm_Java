package com.cheng.面试金典;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author nuonuo
 * @create 2021-07-20 23:12
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 */
public class 零矩阵 {
    public void setZeroes(int[][] matrix) {

        //方法1
        HashSet<Integer> culs = new HashSet<>();
        boolean flag = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    culs.add(j);
                    flag = false;
                }
            }
            if (!flag) {
                Arrays.fill(matrix[i], 0);
                flag = true;
            }
        }
        for (int n : culs) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][n] = 0;
            }
        }
        //方法2
        // HashSet<Integer> pows = new HashSet<>();
        // HashSet<Integer> culs = new HashSet<>();
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[i].length; j++) {
        //         if (matrix[i][j] == 0) {
        //             pows.add(i);
        //             culs.add(j);
        //         }
        //     }
        // }
        // for (int n : pows) {
        //     Arrays.fill(matrix[n], 0);
        // }
        // for (int n : culs) {
        //     for (int i = 0; i < matrix.length; i++) {
        //             matrix[i][n] = 0;
        //     }
        // }
    }
}
