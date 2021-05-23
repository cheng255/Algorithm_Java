package com.cheng.dp;

/**
 * LeetCode338. 比特位计数
 *
 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

 示例 1:

 输入: 2
 输出: [0,1,1]
 示例 2:
 输入: 5
 输出: [0,1,1,2,1,2]
 * @author nuonuo
 * @create 2021-05-23 19:14
 */
public class 比特位计数 {
    //1.
    public int[] countBits01(int num) {
        int[] res = new int[num+1];
        int high = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                high = i;
            }
            res[i] = res[i - high] + 1;
        }
        return res;
    }
    //2.
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i>>1] + (i & 1);
        }
        return res;
    }
}
