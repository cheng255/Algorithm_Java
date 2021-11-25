package day06;

import java.util.TreeSet;

/**
 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 如果存在则返回 true，不存在返回 false。
 示例 1：
 输入：nums = [1,2,3,1], k = 3, t = 0
 输出：true
 示例 2：
 输入：nums = [1,0,1,1], k = 1, t = 2
 输出：true
 示例 3：
 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 输出：false

思路： 看题解    两种方法 我只写了第一种，   11-25   写不动了，下次再做！！！
 1.对于每一个结点，需要查找前k个里是否有符合差值小于k的，所以需要一个滑动窗口保存这个范围
        如果滑动窗口是TreeSet就可以有序，查找O(1)
 */
public class 值和下标之差都在给定的范围内057 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //思路：对于每一个结点，需要查找前k个里是否有符合差值小于k的
        //滑动窗口保存这个k的范围
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling​ = set.ceiling((long)nums[i] - (long)t);//找大于nums[i] - t的数 ceiling
            //也就相当于nums[i] - ceiling <= t
            if (ceiling​ != null && ceiling​ <= (long)nums[i] + (long)t) {
                //相当于  nums[i] - ceiling >= -t
                return true;
            }
            //更新窗口
            set.add((long)nums[i]);
            if (i >= k) {
                set.remove((long)nums[i-k]);
            }
        }
        return false;

    }
}
