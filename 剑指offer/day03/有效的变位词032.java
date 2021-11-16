package day03;

/**
 给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
 注意：若 s 和 t 中每个字符出现的次数都相同且字符顺序不完全相同，则称 s 和 t 互为变位词（字母异位词）。
 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true


 思路：比较简单 ，就hash表判断
 */
public class 有效的变位词032 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int sCount[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--sCount[t.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return !s.equals(t);

    }
}
