package com.cheng.array;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * <p>
 * 双指针解法
 *
 * @author nuonuo
 * @create 2021-09-07 20:01
 */
public class 盛最多水的容器 {
    public int maxArea(int[] height) {

        //解题思路：双指针，l和r  一直移动更小的那个，然后判断容积。
        int l = 0, r = height.length - 1;
        int finalRes = 0;
        while (l < r) {

            // System.out.println(h);
            // System.out.println(res);
            // System.out.println(finalRes);
            int res = 0;
            if (height[l] > height[r]) {
                res = height[r] * (r - l);
                r--;
            } else {
                res = height[l] * (r - l);
                l++;
            }
            finalRes = finalRes > res ? finalRes : res;
        }
        return finalRes;
    }
}
