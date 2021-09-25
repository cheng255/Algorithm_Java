package com.cheng.智商题;

/**
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 * 示例：
 * 输入： a = 1, b = 2
 * 输出： 2
 *
 * 解法：  假设 a和b 的符号位为k    如果 a > b -> k = 1, 否则  k = 0
 *          那么结果就是    a * (k^1) + b * k;
 * @author nuonuo
 * @create 2021-09-25 10:16
 */
public class 最大数值 {
    public int maximum(int a, int b) {
        //如果   a > b  ->  k = 1   否则k = 0
        long k = ((long)a - (long)b) >>> 63;
        return (int)(a * (k^1) + b * k);
    }
}