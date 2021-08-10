package com.cheng.面试金典;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nuonuo
 * @create 2021-08-10 10:25
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 *
 * 说明：解集不能包含重复的子集。
 * 示例:
 *
 *  输入： nums = [1,2,3]
 *  输出：
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class 幂集 {

        List<List<Integer>> res = new ArrayList<>();

        //回溯
         public List<List<Integer>> subsets1(int[] nums) {
             func(nums, 0, new ArrayList<Integer>());
             return res;
         }
         public void func(int[] nums, int step, List<Integer> list) {
             res.add(new ArrayList<>(list));
             for (int i = step; i < nums.length; i++) {
                 list.add(nums[i]);
                 func(nums, i+1, list);
                 list.remove(list.size()-1);
             }
         }


        //选或者不选
        public List<List<Integer>> subsets2(int[] nums) {
            func2(nums, 0, new ArrayList<>());
            return res;
        }
        public void func2(int[] nums, int i, List<Integer> list) {
            if (i >= nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }
            func2(nums, i+1, list);
            list.add(nums[i]);
            func2(nums, i+1, list);
            list.remove(list.size()-1);
        }

        //位运算
         public List<List<Integer>> subsets3(int[] nums) {
             //位运算
             List<List<Integer>> res = new ArrayList<>();
             int len = 1 << nums.length;
             for (int i = 0; i < len; i++) {
                 List<Integer> list = new ArrayList<>();
                 //i的二进制位反应了nums的情况
                 int j = i; int index = nums.length - 1;
                 while (j > 0) {
                     if ((j & 1) == 1) {
                         list.add(nums[index]);
                     }
                     j >>= 1;index--;
                 }
                 res.add(list);
             }
             return res;
         }

}
