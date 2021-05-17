package com.cheng.lanqiao20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * F: 蓝肽子序列
 * @author 86182
 *
 */
public class T6 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		String[] str1 = getArr(s1);
		String[] str2 = getArr(s2);
		System.out.println(Arrays.toString(str1));
		System.out.println(Arrays.toString(str2));
		int[][] dp = new int[str1.length][str2.length];
		dp[0][0] = str1[0].equals(str2[0]) ? 1 : 0;
		for (int i = 1; i < str1.length; i++) {
			if (dp[i-1][0] == 1 || str1[i] == str2[0]) {
				dp[i][0] = 1;
			}
		}
		for (int i = 1; i < str2.length; i++) {
			if (dp[0][i-1] == 1 || str1[0] == str2[i]) {
				dp[0][i] = 1;
			}
		}
		int max = 0;
		for (int i = 1; i < str1.length; i++) {
			for (int j = 1; j < str2.length; j++) {
				max = Math.max(dp[i-1][j], dp[i][j-1]);
				dp[i][j] = str1[i].equals(str2[j]) ? max + 1 : max;
			}
		}
		System.out.println(dp[str1.length-1][str2.length-1]);
	}

	private static String[] getArr(String s) {
		if (s == null || "".equals(s)) {
			return null;
		}
		List<String> list = new ArrayList<>();
		int l = 0, r = 1;
		while (r < s.length()) {
			if (Character.isUpperCase(s.charAt(r))) {
				list.add(s.substring(l, r));
				l = r;
			}
			r++;
		}
		list.add(s.substring(l, r));
		return list.toArray(new String[0]);
	}

}
