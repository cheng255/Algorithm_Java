package com.cheng.string;

import java.util.LinkedList;

/**
 * LeetCode T03 :无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @author nuonuo
 * @create 2020-09-09 15:11
 */
public class LSubstringWithoutRepeatedChars {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    private static int lengthOfLongestSubstring(String s) {
        //思路：使用linkedList 当遇到重复元素时，removeFirst（）到这个重复元素
        LinkedList<Character> list = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (list.contains(temp)) {
                while (!list.isEmpty() && list.removeFirst() != temp) {}
            }
            list.addLast(temp);
            res = (res < list.size()) ? list.size() : res;
        }
        return res;
    }
}
