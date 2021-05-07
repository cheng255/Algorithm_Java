package com.cheng.lanqiao20;

public class T5 {
	public static void main(String[] args) {
		
		int[][] dp = new int[4][4];
		int res = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				//蛇头位置有16种
				dp[i][j] = 1;
				res += func(dp, i, j, 2);
				dp[i][j] = 0;//回溯
			}
		}
		System.out.println(res);
	}

	private static int func(int[][] dp, int i, int j, int cur) {
		if (cur > 16) {
			return 1;
		}
		//首先找到cur可以放的位置
		int res = 0;
		if (i - 1 >= 0 && i - 1 < dp.length && dp[i - 1][j] == 0) {//表示上面可以放cur
			dp[i-1][j] = cur;
			res += func(dp, i-1, j, cur+1);
			dp[i-1][j] = 0;
		}
		if (i + 1 >= 0 && i + 1 < dp.length && dp[i + 1][j] == 0) {//表示下面可以放cur
			dp[i+1][j] = cur;
			res += func(dp, i+1, j, cur+1);
			dp[i+1][j] = 0;
		}
		if (j - 1 >= 0 && j - 1 < dp.length && dp[i][j - 1] == 0) {//表示左面可以放cur
			dp[i][j-1] = cur;
			res += func(dp, i, j-1, cur+1);
			dp[i][j-1] = 0;
		}
		if (j + 1 >= 0 && j + 1 < dp.length && dp[i][j + 1] == 0) {//表示右面可以放cur
			dp[i][j+1] = cur;
			res += func(dp, i, j+1, cur+1);
			dp[i][j+1] = 0;
		}
		return res;
	}

}
