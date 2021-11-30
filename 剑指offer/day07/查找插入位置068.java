package day07;

/**
 给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

 请必须使用时间复杂度为 O(log n) 的算法。

  

 示例 1:

 输入: nums = [1,3,5,6], target = 5
 输出: 2

思路： 二分    二分的题有一些规律，挺简单的
 */
public class 查找插入位置068 {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length-1, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return l;


    }
}
