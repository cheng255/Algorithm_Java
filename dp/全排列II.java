package com.cheng.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * @author nuonuo
 * @create 2021-09-29 16:05
 *
 * 方法： 回溯法
 */
public class 全排列II {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        func(res, nums, 0);
        return res;

    }
    public void func(List<List<Integer>> res, int[] nums, int k) {
        if (k == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = k; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            swap(nums, i, k);
            func(res, nums, k+1);
            swap(nums, i, k);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];//表示这个元素是否被访问
        func1(res, list, nums, 0, vis);
        return res;

    }
    public void func1(List<List<Integer>> res, List<Integer> list, int[] nums, int k, boolean[] vis) {
        if (k == vis.length) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] || (i > 0 && vis[i-1] && nums[i] == nums[i-1])) {
                continue;
            }
            list.add(nums[i]);
            vis[i] = true;
            func1(res, list, nums, k+1, vis);
            vis[i] = false;
            list.remove(k);
        }
    }
}
