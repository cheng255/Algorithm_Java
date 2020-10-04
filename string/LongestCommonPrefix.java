package com.cheng.string;

/**
 * LeetCode T14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * @author nuonuo
 * @create 2020-10-04 13:26
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            len = (strs[i].length() < len) ? strs[i].length() : len;
        }
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < len; j++) {
            int i;
            for (i = 0; i < strs.length - 1; i++) {
                if (strs[i].charAt(j) != strs[i+1].charAt(j)) {
                    break;//当前字符不属于公共前缀
                }
            }
            if (i < strs.length - 1) {
                //提前结束
                return res.toString();
            }
            res.append(strs[0].charAt(j));
        }
        return res.toString();
    }
}
