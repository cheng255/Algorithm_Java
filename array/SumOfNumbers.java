package com.cheng.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author nuonuo
 * @create 2020-11-02 13:41
 */
public class SumOfNumbers {

    /**
     * 两数之和     用HashMap
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], target-nums[i]);
            if(map.get(target-nums[i]) != null)
            {
                res[0] = i;
                int temp = target-nums[i];
                for(int j = 0; j < nums.length; j++) {
                    if(i == j) continue;
                    if(nums[j] == temp)
                    {
                        res[1] = j;
                        return res;
                    }
                }
            }
        }
        return res;
    }
    /**
     * 三数之和  和四数之和方法类似，排序加双指针
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //双指针法
        //首先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            //优化
            if (nums[i] + nums[i+1] + nums[i+2] > 0) {
                break;
            }
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0) {
                continue;
            }
            int j = i+1; int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < 0) {
                    //不够  j++到下一个不同的元素
                    while (j < k && nums[j+1] == nums[j]) j++;
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    //多了  k--到下一个不同的元素
                    while (j < k && nums[k-1] == nums[k]) k--;
                    k--;
                } else {
                    //相同 j++到下一个不同的元素 k--到下一个不同的元素
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]); list.add(nums[j]); list.add(nums[k]);
                    res.add(list);
                    while (j < k && nums[j+1] == nums[j]) j++;
                    j++;
                    while (j < k && nums[k-1] == nums[k]) k--;
                    k--;
                }
            }

        }
        return res;
    }
}
