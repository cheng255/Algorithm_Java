package com.cheng.lanqiao20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class T1 {
	private static HashSet<Integer> set1 = new HashSet<>();
	private static HashSet<Integer> set2 = new HashSet<>();
	private static boolean[][] flag = new boolean[10000][10000];
	public static void main(String[] args) {
		set1.add(50005000);
		set1.add(70205011);
		set1.add(50115014);
		set1.add(70007000);
		for (int i = 0; i < 2020; i++) {
			for (int n : set1) {
				help(n);
			}
			set1.clear();
			set1.addAll(set2);
			set2.clear();
		}
		//最后一轮的
		for (int n : set1) {
			int x = n / 10000;
			int y = n % 10000;
			flag[x][y] = true;
		}
		
		long res = 0;
		for (int i = 0; i < 10000; i++) {
			for (int j = 0; j < 10000; j++) {
				res += flag[i][j] ? 1 : 0;
			}
		}
		System.out.println(res);
	}
	private static void help(int n) {
		int x = n / 10000;
		int y = n % 10000;
		flag[x][y] = true;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (Math.abs(i + j) == 1 && !flag[x+i][y+j]) {
					set2.add((x+i)*10000 + y+j);
				}
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//第一题
//	public static void main(String[] args) {
//		int res = 0;
//		for (int i = 1; i <= 2020; i++) {
//			int j = i;
//			while (j > 0) {
//				if (j % 10 == 2) {
//					res++;
//					break;
//				}
//				j /= 10;
//			}
//		}
//		System.out.println(res);
//	}

}
