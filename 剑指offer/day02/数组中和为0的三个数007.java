package day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nuonuo
 * @create 2021-11-01 12:41
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 *
 * 完成时间 20分钟    和三数之和一样，就是双指针法   比较简单，但还是照了个bug改了一会
 *
 */
public class 数组中和为0的三个数007 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {//选择第一个数
            if (nums[i] > 0) {//第一个都不合符
                break;
            }
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0) {
                continue;
            }
            if (i != 0 && nums[i] == nums[i-1]) {//重复的去掉
                continue;
            }
            //双指针寻找第三个
            int l = i+1, r = nums.length-1;
            int sum = 0;
            while (l < r) {
                sum = nums[l] + nums[r] + nums[i];
                if (sum > 0) {
                    --r;
                } else if (sum < 0) {
                    ++l;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);list.add(nums[l]);list.add(nums[r]);
                    res.add(list);
                    //去重
                    while (l+1 < r && nums[l+1] == nums[l]) {
                        ++l;
                    }
                    while (l+1 < r && nums[r-1] == nums[r]) {
                        --r;
                    }
                    ++l; --r;
                }
            }
        }
        return res;
    }
}
