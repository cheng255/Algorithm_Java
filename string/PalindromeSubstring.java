package com.cheng.string;

/**
 * LeetCode T647:回文子串
 * @author nuonuo
 * @create 2020-09-08 19:22
 */
public class PalindromeSubstring {


    public static void main(String[] args) {
        countSubstrings("asd");
    }

    // 方法1：中心扩展， 奇数和偶数为中心各扩一次
    public static int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i, count);
            helper(s, i, i + 1, count);
        }
        return count;
    }
    private static void helper(String s, int left, int right, int count) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
    }
}
