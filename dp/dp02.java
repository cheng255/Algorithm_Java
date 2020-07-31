package com.cheng.dp;

import java.time.LocalTime;

/**
 * 
 * 给定一个数组arr 每个元素代表一张纸币，单张纸币可以任意次数，aim表示可以换到的整钱 计算共有多少种换到aim的方法
 * 
 * 例如：arr[]{5, 3, 10} aim = 20 3种 ① 4张5块 ② 2张5块 1张10块 ③ 4张5块
 * 
 * @author 86182
 *
 */
public class dp02 {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 2, 10, 8, 6, 11, 80, 9, 14, 1};
		int aim = 100;

		int res = process1(arr, 0, aim);
		System.out.println(res);
		
		int res1 = processDp(arr, aim);
		System.out.println(res1);
	}

	/**
	 * 
	 * @param arr   钱数组
	 * @param index 当前位置
	 * @param aim   目标钱数
	 */
	private static int process1(int[] arr, int index, int aim) {
		int res = 0;
		if (index == arr.length) {
			res = aim == 0 ? 1 : 0;
		} else {
			for (int i = 0; arr[index] * i <= aim; i++) {
				res += process1(arr, index + 1, aim - arr[index] * i);
			}
		}
		return res;
	}
	
	private static int processDp(int[] arr, int aim) {
		int[][] DP = new int[arr.length+1][aim+1];
		DP[arr.length][0] = 1;
		for(int i = arr.length-1; i >= 0; i--) {
			for(int j = 0; j <= aim; j++) {
				if(j - arr[i] >= 0) {
					DP[i][j] = DP[i+1][j] + DP[i][j-arr[i]];
				}else {
					DP[i][j] = DP[i+1][j];
				}
			}
		}
		return DP[0][aim];
	}

}
