package day07;

/**
 给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。

  

 示例 1:
 输入: nums = [1,1,2,3,3,4,4,8,8]
 输出: 2
 示例 2:
 输入: nums =  [3,3,7,7,10,11,11]
 输出: 10
 提示:
 1 <= nums.length <= 105
 0 <= nums[i] <= 105
  

 进阶: 采用的方案可以在 O(log n) 时间复杂度和 O(1) 空间复杂度中运行吗？

 思路：   二分的策略稍微麻烦一点点，   勉强写出来
思路：
 */
public class 排序数组中只出现一次的数字070 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length-1, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (m+1 >= nums.length || m-1 < 0) {
                break;
            }
            if (nums[m] != nums[m+1] && nums[m] != nums[m-1]) {//和前后都不相等
                break;
            }
            //把m移动到 相同字符的第一个   1 ->2 2
            if (nums[m] == nums[m-1]) {
                m = m-1;
            }
            if ((m & 1) == 1) {
                //左边有单数个
                r = m - 1;
            } else {
                l = m+2;
            }
        }
        return nums[m];
    }
}
