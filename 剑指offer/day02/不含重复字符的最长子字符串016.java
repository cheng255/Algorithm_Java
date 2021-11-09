package day02;

import java.util.HashSet;
import java.util.Set;

/**
 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。

 示例 1:

 输入: s = "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
 示例 2:

 输入: s = "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
 示例 3:

 输入: s = "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 示例 4:

 输入: s = ""
 输出: 0

 提示：
 0 <= s.length <= 5 * 104
 s 由英文字母、数字、符号和空格组成

 思路：双指针 + hash表

 */
public class 不含重复字符的最长子字符串016 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (!set.contains(c)) {//不重复
                set.add(c); r++;
                continue;
            }
            //重复了, 计算长度，然后l移动到不重复的位置
            res = Math.max(res, r - l);
            while (s.charAt(l) != c) {
                set.remove(s.charAt(l));
                l++;
            }
            ++l;
            ++r;
        }
        res = Math.max(res, r - l);

        return res;
    }
}
