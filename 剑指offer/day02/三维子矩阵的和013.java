package day02;

import java.sql.Time;

/**
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 *
 * 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * 实现 NumMatrix 类：
 *
 * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2) 返回左上角 (row1, col1) 、右下角 (row2, col2) 的子矩阵的元素总和。
 *  输入:
 * ["NumMatrix","sumRegion","sumRegion","sumRegion"]
 * [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
 * 输出:
 * [null, 8, 11, 12]
 *
 * 解释:
 * NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
 *
 *
 * 思路：还是前缀和      方法1： 一维前缀和     记录每一行的前缀和 然后计算   O(n)
 *                      方法2： 二维前缀和     记录ij位置的前缀和           O(1)
 *                          只是计算方式不一样而已。创建的复杂度一样  方法2的检索效率更高
 *
 */
public class 三维子矩阵的和013 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        System.out.println(new Time(start));
    }
    class NumMatrix1 {
        int[][] sum;
        public NumMatrix1(int[][] matrix) {
            sum = new int[matrix.length+1][matrix[0].length+1];
            for (int i = 1; i <= matrix.length; i++) {
                for (int j = 1; j <= matrix[0].length; j++) {
                    sum[i][j] = sum[i][j-1] + (sum[i-1][j] - sum[i-1][j-1]) + matrix[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1];
        }
    }
    class NumMatrix2 {
        int[][] rowSum;
        public NumMatrix2(int[][] matrix) {
            rowSum = new int[matrix.length][matrix[0].length+1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 1; j <= matrix[i].length; j++) {
                    rowSum[i][j] = rowSum[i][j-1] + matrix[i][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int res = 0;
            while (row1 <= row2) {
                res += (rowSum[row1][col2+1] - rowSum[row1][col1]);
                ++row1;
            }
            return res;
        }
    }
}
