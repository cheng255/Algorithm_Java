package day06;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 示例 1:

 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 输出: [1,2],[1,4],[1,6]
 解释: 返回序列中的前 3 对数：
 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 示例 2:

 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 输出: [1,1],[1,1]
 解释: 返回序列中的前 2 对数：
      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

 思路：还是堆         求大就用小根堆       求小就用大根堆


        但感觉做起来很难受，  不知道是这几天题难了还是我状态不好

 */
public class 和最小的k个数对061 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((o1, o2) ->
                o2.get(0) + o2.get(1) - (o1.get(0) + o1.get(1))
        );

        int len1 = Math.min(nums1.length, k);
        int len2 = Math.min(nums2.length, k);
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                if (pq.size() == k) {
                    if (nums1[i] + nums2[j] < pq.peek().get(0) + pq.peek().get(1)) {
                        pq.poll();
                        pq.offer(list);
                    }
                } else {
                    pq.offer(list);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!pq.isEmpty()){
            res.add(pq.poll());
        }
        return res;

    }
}
