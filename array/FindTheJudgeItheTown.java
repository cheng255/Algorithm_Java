package com.cheng.array;

import java.util.Arrays;

/**
 * LeetCode T997. 找到小镇的法官
 *
 * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 *
 * 如果小镇的法官真的存在，那么：
 *
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 *
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：N = 2, trust = [[1,2]]
 * 输出：2
 * 示例 2：
 *
 * 输入：N = 3, trust = [[1,3],[2,3]]
 * 输出：3
 * 示例 3：
 *
 * 输入：N = 3, trust = [[1,3],[2,3],[3,1]]
 * 输出：-1
 * 示例 4：
 *
 * 输入：N = 3, trust = [[1,2],[2,3]]
 * 输出：-1
 * 示例 5：
 *
 * 输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * 输出：3
 * @author nuonuo
 * @create 2020-09-26 13:48
 */
public class FindTheJudgeItheTown {
    public static void main(String[] args) {
        String s = "1";
        System.out.println(Integer.parseInt(s));
    }
    public int findJudge(int N, int[][] trust) {
        int[] time1 = new int[N];
        int[] time2 = new int[N];
        Arrays.fill(time2, 0);
        Arrays.fill(time1, 0);
        for (int[] arr : trust) {
            time2[arr[1] - 1]++;
            time1[arr[0] - 1]++;
        }
        //       0  1  2  3
        // time1 2  2  0  1
        // time2 0  0  3  2
        for (int i = 0; i < time2.length; i++) {
            if (time2[i] == N - 1 && time1[i] == 0) {
                return i+1;
            }
        }
        return -1;
    }
}
