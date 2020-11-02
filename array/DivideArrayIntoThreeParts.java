package com.cheng.array;

/**
 * LeetCode T1013. 将数组分成和相等的三个部分
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *
 * 形式上，如果可以找出索引 i+1 < j 且满足 A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1] 就可以将数组三等分
 * 输入：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 *
 * @author nuonuo
 * @create 2020-09-26 13:49
 */
public class DivideArrayIntoThreeParts {
    public static void main(String[] args) {
        System.out.println(canThreePartsEqualSum(new int[]{10,-10,10,-10,10,-10,10,-10}));
    }
    public static boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int n : A) {
            sum += n;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int num = sum / 3;
        sum = 0;
        int time = 0;
        for (int aA : A) {
            sum += aA;
            if (sum == num) {
                time++;
                sum = 0;
            }
        }
        return time >= 3; // 大于是防止0的情况
    }
}
