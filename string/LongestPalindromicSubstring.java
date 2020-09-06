package com.cheng.string;

import java.util.Arrays;

/**
 * leetcode T05  最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * @author nuonuo
 * @create 2020-09-06 14:38
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
    private static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        //1.先用 # 将字符隔开，使得偶数个字符时也方便计算
        char[] pre = s.toCharArray();
        char[] now = new char[pre.length * 2 + 1];
        now[0] = '#';
        for(int i = 1, j = 0; i < now.length; i += 2, j++) {
            now[i] = pre[j];
            now[i+1] = '#';
        }
        int bound = 0;//2.用bound记录当前的最右的回文右边界
        int[] r = new int[now.length]; //记录每个字符的回文半径
        r[0] = 0;
        int maxR = r[0]; //最大的回文半径
        int c = 0;//当前的最右回文右半径的中心点下标
        int maxC = 0; //跟最大回文半径一起更新的中心点下标
        int left = -1;
        int right = 1;
        for (int i = 1; i < now.length; i++) {
            if (i > bound) { //当前字符在最右的回文右半径外部==》 暴力扩
                left = i - 1;
                right = i + 1;
                while (left >= 0 && right < now.length && now[left] == now[right]) {
                    left--;
                    right++;
                }
                r[i] = right-1-i; // 记录回文半径
                // 更新最右的回文右半径和中心点
                if (right - 1 > bound) {
                    c = i;
                    bound = right - 1;
                }

            } else { // 当前字符在最右的回文右半径内部
                // 找到相对于c对称的i1点
                int i1 = c - (i-c);
                int l =  Math.abs(i1 - (left + 1));//当前的最左回文左半径到i1的距离
                //根据i1的回文左半径和当前最左回文左半径的位置关系来加速
                if (r[i1] >= l) { //外部或者相同时
                    // 只需要从最右回文右半径的下一个开始判断
                    int left1 = i - l - 1;
                    int right1 = i + l + 1;
                    while (left1 >= 0 && right1 < now.length && now[left1] == now[right1]) {
                        left1--;
                        right1++;
                    }
                    //更新信息
                    r[i] = right1 - i - 1;
                    if (right1 - 1 > bound) {
                        bound = right - 1;
                        c = i;
                        left = left1;
                        right = right1;
                    }
                } else { //内部
                    r[i] = r[i1];
                }
            }
            // 更新maxR和maxC
            if (maxR < r[i]) {
                maxR = r[i];
                maxC = i;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = maxC - maxR; i <= maxC + maxR; i++) {
            if (now[i] == '#') {
                continue;
            }
            res.append(now[i]);
        }
        System.out.println(Arrays.toString(r));
        return res.toString();
    }
}
