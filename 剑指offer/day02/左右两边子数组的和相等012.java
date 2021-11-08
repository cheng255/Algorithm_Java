package day02;

/**
 * @author nuonuo
 * @create 2021-11-02 10:38
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 *
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 *
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,7,3,6,5,6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * 示例 2：
 *
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 * 示例 3：
 *
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心下标是 0 。
 * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
 * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
 *
 *
 * 思路：   前缀和           方法1.判断dp[i] - nums[i]  和   dp[dp.length-1] - dp[i]
 *                          方法2.先记录下总和sum   然后判断   前缀和是否等于  (sum - nums[i]) / 2
 */
public class 左右两边子数组的和相等012 {
    public int pivotIndex2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int mySum = 0;//前缀和
        for (int i = 0; i < nums.length; i++) {
            int temp = sum - nums[i];//剩下的//如果是奇数，就说明一定不能对半分
            if ((temp & 1) == 0 && temp / 2 == mySum) {//前面的和正好等于temp 的一半
                return i;
            }
            mySum += nums[i];
        }
        return -1;
    }
    public int pivotIndex1(int[] nums) {
        int[] dp = new int[nums.length]; dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i-1] + nums[i];
        }
        for (int i = 0; i < dp.length; i++) {
            int left = i == 0 ? 0 : dp[i-1];
            int right = dp[dp.length-1] - dp[i];
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
