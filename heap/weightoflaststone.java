package com.cheng.heap;

import java.util.PriorityQueue;

/**
 * LeetCode T1046. 最后一块石头的重量
 *
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * @author nuonuo
 * @create 2020-10-31 15:42
 */
public class weightoflaststone {
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 2}));
    }

    /**
     * 思路： 使用大顶堆
     * @param stones
     * @return
     */
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int n : stones) {
            heap.offer(n);
        }
        //当前为大顶堆
        int a, b;//最大和次大
        while (heap.size() > 1) {
            a = heap.poll(); b = heap.poll();
            a = a - b;//撞完后a的重量
            if (a != 0) {
                heap.offer(a);
            }
        }
        //还剩最后一个
        return heap.size() == 0 ? 0 : heap.poll();
    }
}
