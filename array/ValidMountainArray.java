package com.cheng.array;

/**
 * LeetCode T941. 有效的山脉数组(easy)
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * @author nuonuo
 * @create 2020-11-03 15:02
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        //双指针  先从头遍历，如果遇到== j直接返回false
        //                  如果遇到峰值停下
        //          然后从后往前遍历  如果可以到达之前的峰值就返回true
        if (A.length < 3) {
            return false;
        }
        int i, j;
        for (i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                return false;
            }
            if (A[i] < A[i - 1]) {//记录峰值下一位
                break;
            }
        }
        if (i == 1 || i >= A.length) {
            //峰值为第一个或最后一个都不符合条件
            return false;
        }
        for (j = i; j < A.length; j++) {
            if (A[j] >= A[j - 1]) { //大于等于前一个数都不行，。只能小于
                return false;
            }
        }
        return true;

    }
}
