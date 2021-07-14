package com.cheng.dp;

/**
 * @author nuonuo
 * @create 2021-07-14 22:
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 *
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接。
输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
输出：true
 */
public class 交错字符串 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if ("".equals(s1) && "".equals(s2)) {
            return "".equals(s3);
        }
        if ("".equals(s1)) {
            return s3.equals(s2);
        }
        if ("".equals(s2)) {
            return s3.equals(s1);
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        //dp[i-1][j-1]表示s1到i, s2到j时是否满足s3要求
        dp[0][0] = true;
        int i = 1;
        while (i <= s1.length())
        {
            if (s1.charAt(i-1) != s3.charAt(i-1)) {
                break;
            }
            dp[i][0] = true; i++;
        }
        i = 1;
        while (i <= s2.length())
        {
            if (s2.charAt(i-1) != s3.charAt(i-1)) {
                break;
            }
            dp[0][i] = true; i++;
        }

        for(i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1))
                        || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));

            }
        }
        return dp[s1.length()][s2.length()];
    }
}
