package com.cheng.array;

/**
 * leetCode T922. 按奇偶排序数组 II
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 * @author nuonuo
 * @create 2020-11-12 23:04
 */
public class SortArrayByParity {
    public int[] sortArrayByParityII(int[] A) {
        //思路：一个奇数位指针i，从1开始 每次+=2  一个偶数位指针j ，从0开始 每次+=2
        //i找到偶数   j找到奇数  然后交换
        int i = 0; int j = 1;
        while (true) {
            while (i < A.length && (A[i] & 1) == 0) {
                i+=2;
            }
            while (j < A.length && (A[j] & 1) == 1) {
                j+=2;
            }
            if (i < A.length && j < A.length) {
                int temp = A[i]; A[i] = A[j]; A[j] = temp;
                continue;
            }
            break;
        }
        return A;
    }
}
