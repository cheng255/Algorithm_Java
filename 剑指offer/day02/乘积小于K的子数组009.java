package day02;

/**
 * @author nuonuo
 * @create 2021-11-01 21:13
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * 示例 2:
 *
 * 输入: nums = [1,2,3], k = 0
 * 输出: 0
 *  
 * 提示: 
 *
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 *
 *
 * 思路：看了题解    是特殊一点的滑动窗口问题。  下次再理解理解！！！
 *
 * 我自己写的代码想当丑陋
 */
public class 乘积小于K的子数组009 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int grand = 1;
        int r = 0, l = 0;
        while (r < nums.length) {
            grand *= nums[r];
            //新加入的r元素
            while (l <= r && grand >= k) {
                grand /= nums[l++];
            }
            res += r-l+1;
            ++r;
        }
        return res;
    }
}
