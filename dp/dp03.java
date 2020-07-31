package com.cheng.dp;
/**
 * 阿里面试题
 * 
 * 一共有N个位置，一开始停留在M位置上， 可以走P步， 最终停留在K位置的走法有多少种
 * 
 * @author 86182
 *
 */
public class dp03 {
	public static void main(String[] args) {
		int res = ways(10, 5, 20, 7);
		System.out.println(res);
		int res1 = waysDp(10, 5, 20, 7);
		System.out.println(res1);
	}
	
	
	private static int ways(int N, int M, int P, int K) {
		if(N < 2 || M < 1 || M > N || P < 0 || K < 1 || K > N) {
			return 0;
		}
		if(P == 0) {
			return M == K ? 1 : 0;
		}
		int res = 0;
		if (M == 1) {
			res = ways(N, M+1, P-1, K);
		} else if(M == N) {
			res = ways(N, M-1, P-1, K);
		} else {
			res = ways(N, M-1, P-1, K) + ways(N, M+1, P-1, K);
		}
		return res;		
	}
	
	private static int waysDp(int N, int M, int P, int K) {
		if(N < 2 || M < 1 || M > N || P < 0 || K < 1 || K > N) {
			return 0;
		}
		int[][] DP = new int[P+1][N+1];
		DP[0][K] = 1;
		for(int i = 1; i <= P; i++) {
			DP[i][1] = DP[i-1][2];
			DP[i][N] = DP[i-1][N-1];
			for(int j = 2; j <= N-1; j++) {
				DP[i][j] = DP[i-1][j-1] + DP[i-1][j+1];
			}
		}
		
		return DP[P][M];
		
	}

}
