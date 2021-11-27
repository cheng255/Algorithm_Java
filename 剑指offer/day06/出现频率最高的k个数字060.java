package day06;

import java.util.*;

/**
 给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。

  

 示例 1:

 输入: nums = [1,1,1,2,2,3], k = 2
 输出: [1,2]
 示例 2:

 输入: nums = [1], k = 1
 输出: [1]
 进阶：所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。

        思路：    1.堆   2.快速排序        详情看题解
 */
public class 出现频率最高的k个数字060 {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        PriorityQueue<List<Integer>> ad = new PriorityQueue<>((o1, o2) -> o1.get(0) + o1.get(1) - (o2.get(0) + o2.get(1))
        );

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int[] res = new int[k];
        Set<Integer> keys = map.keySet();
        for (int key : keys) {
            if (pq.size() == k) {
                if (map.get(key) > pq.peek()[1]) {
                    pq.poll();
                    pq.offer(new int[]{key, map.get(key)});
                }
            } else {
                pq.offer(new int[]{key, map.get(key)});
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
