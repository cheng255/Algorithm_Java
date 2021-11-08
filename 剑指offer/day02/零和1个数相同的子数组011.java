package day02;

import java.util.HashMap;

/**
 * @author nuonuo
 * @create 2021-11-02 9:54
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * 示例 2:
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 *
 *
 * 思路：还是前缀和 + hash表     不必多说
 */
public class 零和1个数相同的子数组011 {
    public int findMaxLength(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length]; dp[0] = nums[0] == 0 ? -1 : 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i-1] + (nums[i] == 0 ? -1 : 1);
        }
        // System.out.println(Arrays.toString(dp));
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 0) {
                res = i+1;
                continue;
            }
            int j = map.getOrDefault(dp[i], -1);
            if (j == -1) {
                map.put(dp[i], i);
            } else if (i - j > res) {
                res = i - j;
            }

        }
        return res;

    }
}
