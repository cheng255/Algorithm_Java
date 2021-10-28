package com.cheng.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author nuonuo
 * @create 2021-10-28 12:35
 *
 * 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 *
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：1
 * 输出：true
 * 示例 2：
 *
 * 输入：10
 * 输出：false
 * 示例 3：
 *
 * 输入：16
 * 输出：true
 * 示例 4：
 *
 * 输入：24
 * 输出：false
 * 示例 5：
 *
 * 输入：46
 * 输出：true
 *
 *
 * 思路：打表  + 计算词频            知识：   如果 n 是 2的幂次方    那么  n & n-1 == 0
 */
public class 重新排序得到2的幂 {
    Set<Integer> set = new HashSet<>();
    public boolean reorderedPowerOf2(int n) {
        int[] nums = new int[10];
        func(n, nums);

        for (int i = 0; i <= 30; i++) {
            set.add(1 << i);
        }
        int[] cuts = new int[10];
        out : for (int num : set) {
            Arrays.fill(cuts, 0);
            func(num, cuts);
            //判断单词频率是否一致

            for (int i = 0; i < 10; i++) {
                if (nums[i] != cuts[i]) continue out;
            }
            return true;
        }
        return false;

    }
    public void func(int num, int[] cuts) {
        while (num > 0) {
            cuts[num % 10]++;
            num /= 10;
        }
    }
}
