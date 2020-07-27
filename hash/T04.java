package com.cheng.hash;
//厄拉多塞筛法

import java.util.Arrays;

//统计所有小于非负整数 n 的质数的数量。
public class T04 {
	public static void main(String[] args) {
		int countPrimes = countPrimes(10);
		System.out.println(countPrimes);
	}

	private static int countPrimes(int n) {
		if (n <= 2) return 0;
		boolean[] isPrime = new boolean[n];// 先将所有数标记为质数
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;// 将0和1标记为非质数

		// 从3开始遍历所有奇数
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (!isPrime[i])
				continue;// 不是奇数直接跳过
			for (int j = i << 1; j < n; j += i) {// 是奇数的话把他的倍数全部标记为非质数
				isPrime[j] = false;
			}
		}
		int count = 0;
		for (boolean prime : isPrime) {//统计数组中素数的数量
			if (prime)
				count++;
		}
		return count;
	}
}
