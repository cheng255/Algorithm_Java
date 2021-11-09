package day02;

import java.util.ArrayList;
import java.util.List;

/**
 给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 变位词 指字母相同，但排列不同的字符串。

 示例 1:

 输入: s = "cbaebabacd", p = "abc"
 输出: [0,6]
 解释:
 起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
 起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
  示例 2:

 输入: s = "abab", p = "ab"
 输出: [0,1,2]
 解释:
 起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
 起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
 起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
  
 提示：
 1 <= s.length, p.length <= 3 * 104
 s 和 p 仅包含小写字母


 和014题基本一样
 */
public class 字符串中的所有变位词015 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] t = new int[26];
        for (int i = 0; i < p.length(); i++) {
            t[p.charAt(i)-97]--;
        }
        int l = 0, r= 0;
        while (r < s.length()) {
            t[s.charAt(r)-97]++;
            while (t[s.charAt(r)-97] > 0) {
                t[s.charAt(l)-97]--;
                ++l;
            }
            if (r - l + 1 == p.length()) {
                res.add(l);
                t[s.charAt(l++)-97]--;
            }
            r++;
        }
        return res;
    }
}
