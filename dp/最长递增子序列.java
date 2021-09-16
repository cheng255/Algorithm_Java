package com.cheng.dp;

/**
 *
 * leetcode300题：
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * @author nuonuo
 * @create 2021-09-16 16:23
 */
public class 最长递增子序列 {
    //动态规划
    // public int lengthOfLIS(int[] nums) {
    //     int[] dp = new int[nums.length];
    //     int res = 0;
    //     for (int i = 0; i < dp.length; i++) {
    //         int max = 0;
    //         for (int j = 0; j < i; j++) {
    //             if (nums[j] < nums[i] && dp[j] > max) {
    //                 //符合递增中找到最大的
    //                 max = dp[j];
    //             }
    //         }
    //         dp[i] = max + 1;
    //         res = Math.max(dp[i], res);
    //     }
    //     return res;
    // }
    //贪心 + 二分查找
    public int lengthOfLIS(int[] nums) {
        int len = 1;
        int[] dp = new int[nums.length+1];
        dp[len] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[len]) {
                dp[++len] = nums[i];
            } else {
                int left = 1, right = len, mid = 0, pos = 0;
                while (left <= right) {
                    mid = (left + right) / 2;
                    if (dp[mid] >= nums[i]) {
                        right = mid - 1;
                    } else {
                        pos = mid;
                        left = mid + 1;
                    }
                }
                dp[pos+1] = nums[i];
            }
        }
        // System.out.println(Arrays.toString(dp));
        return len;
    }
}
