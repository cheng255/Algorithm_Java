package com.cheng.heap;

import java.util.*;

/**
 * LeetCode373. 查找和最小的K对数字
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 *
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *      [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 *
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 示例 3:
 *
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 * @author nuonuo
 * @create 2020-10-31 13:43
 */
public class FindKPairNumber {

    public static void main(String[] args) {
        int[]nums1 = {1,3,7,11}, nums2 = {2,4,6}; int k = 3;
        List<List<Integer>> lists = kSmallestPairs(nums1, nums2, k);
        for (int i = 0; i < lists.size(); i++) {
            System.out.print(lists.get(i));
        }
    }

    /**
     * 思路：用堆来解决
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums1 == null || nums2 == null) {
            return res;
        }
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(o -> (o.get(0) + o.get(1))));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                queue.offer(list);
            }
        }
        for (int i = 0; i < k; i++) {
            if (queue.peek() == null) {
                break;
            }
            res.add(queue.poll());
        }
        return res;
    }















}
