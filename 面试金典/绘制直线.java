package com.cheng.面试金典;

/**
 * 绘制直线。有个单色屏幕存储在一个一维数组中，使得32个连续像素可以存放在一个 int 里。屏幕宽度为w，且w可被32整除（即一个 int 不会分布在两行上），屏幕高度可由数组长度及屏幕宽度推算得出。请实现一个函数，绘制从点(x1, y)到点(x2, y)的水平线。
 *
 * 给出数组的长度 length，宽度 w（以比特为单位）、直线开始位置 x1（比特为单位）、直线结束位置 x2（比特为单位）、直线所在行数 y。返回绘制过后的数组。
 * @author nuonuo
 * @create 2021-08-07 10:30
 *
 *
 * 2
 * 64
 * 0
 * 52
 * 0
 * 输出
 * [-1,-2048]
 * 预期结果
 * [-1,-2048]
 *  输入：length = 1, w = 32, x1 = 30, x2 = 31, y = 0
 *  输出：[3]
 *  说明：在第0行的第30位到第31为画一条直线，屏幕表示为[0b000000000000000000000000000000011]
 */
public class 绘制直线 {
    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] res = new int[length];
        int r = w / 32 * y;
        int r1 = x1 / 32 + r;
        int r2 = x2 / 32 + r;
        if (r1 == r2) {//表示他们在同一个数组中
            res[r1] = (int)(long)(Math.pow(2, 32 - (x1 % 32)) - 1);
            res[r1] &= ~(int)(long)(Math.pow(2, 32 - (x2 % 32) - 1) - 1);
        } else {
            res[r2] = (int)(long)(Math.pow(2, 32) - 1);
            res[r2] &= ~(int)(long)(Math.pow(2, 32 - (x2 % 32) - 1) - 1);
            res[r1] = (int)(long)(Math.pow(2, 32 - (x1 % 32)) - 1);
        }
        for (int i = r1 + 1; i < r2; i++) {
            res[i] = -1;
        }
        return res;
    }
}