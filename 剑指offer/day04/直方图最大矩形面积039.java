package day04;

import java.util.Stack;

/**
 给定非负整数数组 heights ，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 示例 1:
 输入：heights = [2,1,5,6,2,3]
 输出：10
 解释：最大的矩形为图中红色区域，面积为 10

 思路：        1.我的思路：中心扩展，以一个高度中心扩展，最差情况为O(n^2)过不了，所以用flag数组去重，
                                如果扩展到的位置和中心位置一样高，那他就不需要再扩展了
                2.题解：单调栈    O(N)
        其实两种方法的解题思路差不多， 都是看以当前位置为顶 可以扩多远

 */
public class 直方图最大矩形面积039 {
    //单调栈
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                res = Math.max(res, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            res = Math.max(res, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return res;
    }
    //中心扩展
    public int largestRectangleArea1(int[] heights) {
        int res = 0;
        int l = 0, r = 0;
        boolean[] flag = new boolean[heights.length];
        for (int i = 0; i < heights.length; i++) {
            //中心扩展
            if (flag[i]) continue;
            l = i-1; r = i+1;
            int sum = heights[i];
            while (l >= 0 && heights[l] >= heights[i]) {
                sum += heights[i];
                if (heights[l] == heights[i])
                    flag[l] = true;
                l--;
            }
            while (r < heights.length && heights[r] >= heights[i]) {
                sum += heights[i];
                if (heights[r] == heights[i])
                    flag[r] = true;
                r++;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
