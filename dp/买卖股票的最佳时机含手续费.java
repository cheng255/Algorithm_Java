package com.cheng.dp;

/**
 * LeetCode714. 买卖股票的最佳时机含手续费
 * @author nuonuo
 * @create 2021-05-31 11:18
 */
public class 买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // int[][] dp = new int[n][2];
        int no = 0;
        int yes = -prices[0];
        //dp[i][0]表示到第i天，手里没股票时的最大收益
        //dp[i][1]表示到第i天，手里有股票时的最大收益
        // dp[0][0] = 0;
        // dp[0][1] = //买入就代表用了本军，也就是收益减了
        int temp = 0;
        for (int i = 1; i < n; i++) {
            // dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            // dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            temp = no;
            no = Math.max(no,yes + prices[i] - fee);
            yes = Math.max(yes, temp - prices[i]);
        }
        return no;
    }
}
