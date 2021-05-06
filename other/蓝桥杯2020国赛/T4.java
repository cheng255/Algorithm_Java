package com.cheng.lanqiao20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class T4 {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("inc.txt"));
		String s = "";
		while (sc.hasNext()) {
			s = s + sc.next();
		}
		System.out.println(s);
		char[] chars = s.toCharArray();
		int[] dp = new int[chars.length];
		// dp[0] = 1 表示以0号下标元素结尾的递增子序列有多少个
		Arrays.fill(dp, 1);//以i结尾的至少都有本身这一种结果
		int res = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (chars[i] > chars[j]) {
					dp[i] += dp[j];
				}
				if (chars[i] == chars[j]) {
					dp[i] -= dp[j];
				}
			}
			res += dp[i];
		}
		System.out.println(res);
	}

}
