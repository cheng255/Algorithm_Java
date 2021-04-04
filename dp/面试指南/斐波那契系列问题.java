package com.cheng.dp.面试指南;

/**
 * T:斐波那契系列问题的递归和动态规划
 * <p>
 * 1.返回斐波那契数列的第N项
 * <p>
 * 2.爬台阶问题，一次爬1或2阶，爬上N阶有多少种
 * <p>
 * 3.母牛不死，第二年开始每年生小母牛，小母牛过3年之后也开始生，求N年后牛的数量，
 * <p>
 * 要求：时间复杂度 O(LogN)
 * 思路：需要用到矩阵乘法的思路找到关系递推矩阵，将问题转化为求矩阵的N次方问题。
 * 比如是求75次方  75二进制是1001011   利用二进制可以到达logN的效果
 * <p>
 * 题目：给定整数N,返回斐波那契数列的第N项
 *
 *
 * 总结：如果递推式严格符合 F(n)=a*F(n-1)+b*F(n-2)+...+k*F(n-i)
 *      那么它就是一个i阶的递推式，必然有与 i*i 的状态矩阵有关的矩阵乘法的表达。
 *      都可以用加速矩阵乘法的动态规划将时间复杂度降到 O(LogN)
 *
 * @author nuonuo
 * @create 2021-04-01 12:45
 */
public class 斐波那契系列问题 {
    public static void main(String[] args) {
        climbStairs(3);
        for (int i = 0; i < 10; i++) {
            System.out.println(Fibonacci(i));
        }
        countCow(3);
    }

    private static int countCow(int n) {//3/
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        //递推公式  f(n) = f(n-1)+f(n-3)
        //母牛问题不同的是递推是三阶递推数列 ，所以递推矩阵是三阶
        //递推矩阵(n, n - 1, n - 2) = (3, 2, 1) * base^(n-3)
        int[][] base = new int[][]{{1, 1, 0}, {0, 0, 1}, {1, 0, 0}};
        int[][] res = matrixPower(base, n - 3);
        return 3*res[0][0] + 2*res[1][0] + res[2][0];
    }

    private static int Fibonacci(int n) {//1/
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        //递推公式  f(n) = f(n-1)+f(n-2)
        //二阶递推矩阵    (n, n - 1) = (1, 0) * base^(n-2)
        int[][] base = new int[][]{{1, 1}, {1, 0}};//递推矩阵
        int[][] res = matrixPower(base, n - 2);
        return res[0][0] + res[1][0];
    }

    private static int climbStairs(int n) {//2/
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        //递推公式  f(n) = f(n-1)+f(n-2)
        //二阶递推    (n, n - 1) = (2, 1) * base^(n-2)
        int[][] base = new int[][]{{1, 1}, {1, 0}};//递推矩阵
        int[][] res = matrixPower(base, n - 2);
        return 2 * res[0][0] + res[1][0];
    }

    //求base的k次方
    private static int[][] matrixPower(int[][] base, int k) {
        int[][] res = new int[base.length][base[0].length];
        //因为要求次方，所以先将矩阵初始化为1
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] temp = base;
        for (; k > 0; k >>= 1) {
            if ((k & 1) == 1) {//说明当前二进制最低位为1
                res = matrixMultiplication(res, temp);
            }
            temp = matrixMultiplication(temp, temp);
        }
        return res;
    }

    //矩阵乘法
    private static int[][] matrixMultiplication(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                //矩阵res[i][j]的值等于  m1的第i行的每一个元素  *  m2的第j列的每一个元素   相加而来
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

}
