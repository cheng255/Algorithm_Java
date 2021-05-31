package com.cheng.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * LeetCode131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 * @author nuonuo
 * @create 2021-05-31 10:31
 */
public class 分割回文串 {
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    boolean[][] flags = null;//表示i-j是否为回文
    public List<List<String>> partition(String s) {
        int n = s.length();
        flags = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(flags[i], true);
        }
        for (int i = n - 1; i >= 0; --i) {//这里的逻辑！！！一定要这样遍历
            for (int j = i + 1; j < n; j++) {
                flags[i][j] = flags[i+1][j-1] && (s.charAt(i) == s.charAt(j));
            }
        }
        dp(s, n, 0);
        return res;
    }
    public void dp(String s, int n, int k) {
        if (k >= n) {
            res.add(new ArrayList<String>(list));
            return;
        }
        //将当前所有的回文串依次加入list，然后递归去加下一组
        for (int i = k; i < n; i++) {
            if (!flags[k][i]) {//不是回文就跳过
                continue;
            }
            list.add(s.substring(k, i+1));
            dp(s, n, i+1);
            list.remove(list.size()-1);
        }
    }
}
