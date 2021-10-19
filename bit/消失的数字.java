package com.cheng.bit;

/**
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 * 注意：本题相对书上原题稍作改动
 * <p>
 * 示例 1：
 * 输入：[3,0,1]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：[9,6,4,2,3,5,7,0,1]
 * 输出：8
 *
 * 解法   巧妙应用异或     异或两个相同的数，结果不变
 *
 * @author nuonuo
 * @create 2021-10-19 21:53
 */
public class 消失的数字 {

    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= nums.length;
        return res;
    }

}
