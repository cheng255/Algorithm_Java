package com.cheng.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode T18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 *
 * 为了实现上述要求，可以对数组进行排序，并且在循环过程中遵循以下两点：
 *
 * 每一种循环枚举到的下标必须大于上一重循环枚举到的下标；
 *
 * 同一重循环中，如果当前元素与上一个元素相同，则跳过当前元素。
 *
 * 使用上述方法，可以避免枚举到重复四元组，但是由于仍使用四重循环，时间复杂度仍是 O(n^4)O(n
 * 4
 *  )。注意到数组已经被排序，因此可以使用双指针的方法去掉一重循环。
 *
 * 使用两重循环分别枚举前两个数，然后在两重循环枚举到的数之后使用双指针枚举剩下的两个数。假设两重循环枚举到的前两个数分别位于下标 ii 和 jj，其中 i<ji<j。初始时，左右指针分别指向下标 j+1j+1 和下标 n-1n−1。每次计算四个数的和，并进行如下操作：
 *
 * 如果和等于 \textit{target}target，则将枚举到的四个数加到答案中，然后将左指针右移直到遇到不同的数，将右指针左移直到遇到不同的数；
 *
 * 如果和小于 \textit{target}target，则将左指针右移一位；
 *
 * 如果和大于 \textit{target}target，则将右指针左移一位。
 *
 * 使用双指针枚举剩下的两个数的时间复杂度是 O(n)O(n)，因此总时间复杂度是 O(n^3)O(n3)，低于 O(n^4)O(n4)。
 *
 * 具体实现时，还可以进行一些剪枝操作：
 *
 * 在确定第一个数之后，如果nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target，说明此时剩下的三个数无论取什么值，四数之和一定大于target，因此退出第一重循环；
 * 在确定第一个数之后，如果nums[i]+nums[n−3]+nums[n−2]+nums[n−1]<target，说明此时剩下的三个数无论取什么值，四数之和一定小于target，因此第一重循环直接进入下一轮，枚举 \textit{nums}[i+1]nums[i+1]；
 * 在确定前两个数之后，如果nums[i]+nums[j]+nums[j+1]+nums[j+2]>target，说明此时剩下的两个数无论取什么值，四数之和一定大于target，因此退出第二重循环；
 * 在确定前两个数之后，如果nums[i]+nums[j]+nums[n−2]+nums[n−1]<target，说明此时剩下的两个数无论取什么值，四数之和一定小于target，因此第二重循环直接进入下一轮，枚举 \textit{nums}[j+1]nums[j+1]。
 * @author nuonuo
 * @create 2020-11-01 17:21
 */
public class SumOfFour {
    public static void main(String[] args) {
        List<List<Integer>> lists = fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(lists);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        //首先将nums数组排序
        Arrays.sort(nums);
        //穷举前两位，后两位用双指针   不可以包含重复 -> 四个变量递增穷举
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;//每层循环中遇到相同值过 因为第一个数是该值的所有情况已经穷举完了
            }
            //优化
            if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) {
                //最小的时候还是大于target，退出循环
                break;
            }
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) {
                //最大的时候还是小于target,进入下一轮
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;//每层循环中遇到相同值过
                }
                //优化
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    //最小的时候还是大于target，退出循环
                    break;
                }
                if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target) {
                    //最大的时候还是小于target,进入下一轮
                    continue;
                }

                int k = j + 1, l = nums.length - 1;//初始化指向两端
                while (k < l) {
                    if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
                        //k++到下一个不等于nums[k]的数
                        while (k < l && nums[k+1] == nums[k]) {
                            k++;
                        }
                        k++;
                    } else if (nums[i] + nums[j] + nums[k] + nums[l] > target) {
                        //l--到下一个不等于nums[l]的数
                        while (k < l && nums[l-1] == nums[l]) {
                            l--;
                        }
                        l--;
                    } else {
                        //找到符合条件的四个数
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);list.add(nums[j]);list.add(nums[k]);list.add(nums[l]);
                        res.add(list);
                        //k++到下一个不等于nums[k]的数
                        while (k < l && nums[k+1] == nums[k]) {
                            k++;
                        }
                        k++;
                        //l--到下一个不等于nums[l]的数
                        while (k < l && nums[l-1] == nums[l]) {
                            l--;
                        }
                        l--;
                    }
                }
            }
        }
        return res;
    }
}
