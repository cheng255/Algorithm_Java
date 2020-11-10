package com.cheng.dp;

/**
 * 剑指 Offer. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @author nuonuo
 * @create 2020-11-10 15:21
 */
public class MaxSumOfSubarrays {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
    public static int maxSubArray(int[] nums) {
        int dp = nums[0];//表示以i结尾的子数组的最大和
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            dp = dp > 0 ? dp + nums[i] : nums[i];
            max = dp > max ? dp : max;
        }

        return max;
    }
}
