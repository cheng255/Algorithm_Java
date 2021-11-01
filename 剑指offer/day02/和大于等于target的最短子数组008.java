package day02;

/**
 * @author nuonuo
 * @create 2021-11-01 13:24
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *  
 *
 * 进阶：
 *
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 *
 *
 *
 * 比较简单，直接双指针滑动窗口就行了  O(n log(n)) 时间复杂度的解法指的是  计算前缀和 + 二分查找
 *
 */
public class 和大于等于target的最短子数组008 {
    public int minSubArrayLen1(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i-1] + nums[i];
        }//计算了所有的前缀和
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return 1;
            if (dp[i] < target) {
                continue;
            }
            //枚举每一个前缀和，然后去二分找   dp[i] - dp[j] >= target 的最大的j
            //也就是找  正好小于等于 dp[i] - target 的位置
            int l = 0, r = i-1, m = 0;
            while (l <= r) {
                m = (l + r) / 2;
                if (dp[m] <= dp[i] - target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            res = Math.min(res, i - r);

        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] >= target) {
                return 1;//一个就够
            }
            sum += nums[r];
            if (sum >= target) {
                while (sum >= target && l < r) {
                    sum -= nums[l++];
                }
                res = Math.min(res, r-l+2);
            }
            r++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
