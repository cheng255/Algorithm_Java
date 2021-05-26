package com.cheng.dp;

/**
 * leetcode91.解码方法
 * @author nuonuo
 * @create 2021-05-26 21:11
 */
public class 解码方法 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        int p = 0;
        int n = s.charAt(0) - '0';
        dp[0] = n == 0 ? 0 : 1;
        if (s.length() == 1) {
            return dp[0];
        }
        p = n;
        //如果当前位置元素合法 dp[i] += dp[i-1]
        //如果当前位置和前一位加起来合法，就  dp[i] += dp[i-2]
        n = s.charAt(1) - '0';
        dp[1] = n == 0 ? 0 : dp[0];
        if (p != 0 && p * 10 + n <= 26) {
            dp[1] += 1;
        }
        p = n;
        for (int i = 2; i < s.length(); i++) {
            n = s.charAt(i) - '0';
            dp[i] = n == 0 ? 0 : dp[i-1];
            if (p != 0 && p * 10 + n <= 26) {
                dp[i] += dp[i-2];
            }
            p = n;
        }
        return dp[s.length()-1];

    }
}
