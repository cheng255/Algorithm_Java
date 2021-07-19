package com.cheng.面试金典;

/**
 * @author nuonuo
 * @create 2021-07-19 17:31
 *
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *
 *  
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 */
public class 旋转矩阵 {
    public void rotate(int[][] matrix) {
        //将每一圈分别进行旋转
        int i = 0, j = 0;
        int up = 0, down = matrix.length - 1, left = 0, right = matrix.length - 1;
        while (up < down) {
            i = up; j = left;
            while (i < down) {
                swap(matrix, i, j, j, matrix.length - 1 - i);
                i++;
            }

            while (j < right) {
                swap(matrix, i, j, j, matrix.length - 1 - i);
                j++;
            }
            while (i > up) {
                swap(matrix, i, j, j, matrix.length - 1 - i);
                i--;
            }
            // while (j > left) {
            //     swap(matrix, i, j, j, matrix.length - 1 - i);
            //     j--;
            // }
            left++;
            right--;
            down--;
            up++;
        }
    }
    public void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }
}
