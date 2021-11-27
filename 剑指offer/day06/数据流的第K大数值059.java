package day06;

import java.util.Arrays;

/**
 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。

 请实现 KthLargest 类：

 KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 示例：
 输入：
 ["KthLargest", "add", "add", "add", "add", "add"]
 [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 输出：
 [null, 4, 5, 5, 8, 8]

 解释：
 KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 kthLargest.add(3);   // return 4
 kthLargest.add(5);   // return 5
 kthLargest.add(10);  // return 5
 kthLargest.add(9);   // return 8
 kthLargest.add(4);   // return 8

 思路：建立小根堆
        我自己写的堆，，题解用的类库PriorityQueue
 */
public class 数据流的第K大数值059 {
    int[] heap;
    public 数据流的第K大数值059(int k, int[] nums) {
        creatHeap(nums, k);
//        new PriorityQueue
    }

    public int add(int val) {
        if (val > heap[0]) {
            heap[0] = val;
            down(0);
        }
        return heap[0];
    }

    public void creatHeap(int[] nums, int k) {
        //1.建大小为k的小根堆。保留nums里的前k大的数
        heap = Arrays.copyOf(nums, k);
        //2.不够k的地方填上Integer.MIN_VALUE
        if (nums.length < k) {
            Arrays.fill(heap, nums.length, k, Integer.MIN_VALUE);
        }
        for (int i = heap.length/2-1; i >= 0; i--) {
            down(i);
        }
        //3.多的筛选
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap[0]) {//比最小的大，往下筛选
                heap[0] = nums[i];
                down(0);
            }
        }
    }

    public void down(int i) {

        while (i < heap.length/2) {
            int min = i * 2 + 1;
            if (min + 1 < heap.length && heap[min+1] < heap[min]) {
                min = min+1;
            }
            if (heap[min] < heap[i]) {
                {int temp = heap[min]; heap[min] = heap[i]; heap[i] = temp;}
                i = min;
            } else {
                break;
            }
        }
    }
}
