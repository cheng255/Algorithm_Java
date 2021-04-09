package com.cheng.dp.面试指南;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定数组arr，返回arr的最长递增子序列
 * 例：[2,1,5,3,6,4,8,9,7] => [1,3,4,8,9]
 * <p>
 * 要求 时间复杂度 O(NlogN)
 * @author nuonuo
 * @create 2021-04-05 16:05
 */
public class 最长递增子序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] res = longestIncreasingSubsequence(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] longestIncreasingSubsequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        //1.dp[i]表示以i为尾的最长递增子序列  dp[i] = max(dp[0],...dp[i-1]) + 1
        int[] dp = getDpNB(arr);
        //2.用dp去找到最长序列
        int[] res = getSubsequence(arr, dp);
        return res;
    }

    /**
     * 通过dp数组去找递增序列
     *      先找到dp中最大的数，并把下标记录为index然后向左边遍历
     *      比如最大的数是5，下标为i,表示最长递增子序列长度为5，记录下来，arr[i]就是序列中的末尾元素
     *      然后向左遍历找dp值为4的下标j,然后arr[j]就是序列中倒数第二的元素，以此类推。
     */
    private static int[] getSubsequence(int[] arr, int[] dp) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }
        int[] res = new int[max];
        res[--max] = arr[index];
        for (int i = index - 1; i >= 0; i--) {
            if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
                res[--max] = arr[i];
                index = i;
            }
        }
        return res;
    }

    /**
     * 时间复杂度O(NlogN)的方法
     * 利用二分法，对getDp()进行了优化，
     * 维护一个ends数组来记录有效的递增序列，right变量表示有效区间的最右边
     * 比如   ends[] = {2,4,6}   表示   长度为 1的递增序列最小的结尾是2
     *                                  长度为2的递增序列最小的结尾是4
     *                                  长度为3的递增序列最小的结尾是6
     *        可以看到用这个方法的话，ends是自然有序的。
     *        这时候如果遍历到arr[i] = 3   就用二分查找找到最左边比它大的数   就是4，然后ends[1]=3
     *                          也就是说长度为2的递增序列最小的结尾变成了3
     *                         依次类推...
     *        dp依旧是之前的含义 dp[i]表示0-i范围的最长递增子序列的长度。也就是ends的长度了。
     */
    private static int[] getDpNB(int[] arr) {
        int[] ends = new int[arr.length];
        int[] dp = new int[arr.length];
        int right = 0;
        int l = 0;int r = 0;int m = 0;
        ends[0] = arr[0];
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            r = right;
            while (l <= r) {//1.利用二分法在ends有效区里找到最左边比arr[i]大的元素
                m = (l + r) / 2;
                if (arr[i] > ends[m]) {
                    l = m + 1;
                } else {//等于和小于一起处理，因为是要找到最左边的
                    r = m - 1;
                }
            }
            //到这里有两种情况，
            // 1：找到了,将这个位置l的ends【l】元素设置为arr[i],表示长度为l+1的递增序列最小的结尾为arr[i]，dp[]
            //2: 没找到，两种情况：
            //          （1）arr[i]比ends里所有元素都要小，这种情况l还是0位置，说明以arr[i]结尾的递增序列长度为1
            //          （2）arr[i]比ends里所有元素都要大，这种情况 l = right + 1，以arr[i]结尾有效递增序列加了1
            right = Math.max(right, l);
            ends[l] = arr[i];
            dp[i] = l + 1;
        }
        return dp;
    }

    /**
     *这是O(N2)的时间复杂度的
     *
     * dp[i] 表示 0-i范围内最长的递增子序列
     * 要求dp[i]，只需要找到max(dp[j]) (j < i && arr[j] < arr[i])
     *          既找到 0 - i-1 范围内最长的递增子序列且结尾元素比当前元素小的值加1就行了
     */

    private static int[] getDp(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }
}
