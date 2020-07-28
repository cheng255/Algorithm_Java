package com.cheng.kmp;

import java.util.Arrays;

/*
 * 
 * KMP算法
 * 
 * 1.先得到子串的部分匹配表，既最大前后缀差值
 * 2.使用部分匹配表完成KMP匹配
 * 
 * 
 */
public class KMPAlgorithm {
	public static void main(String[] args) {
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		String str2 = "ABCDABD";
		int[] next = kmpNext(str2);
		System.out.println(Arrays.toString(next));
		
		int index = kmpSearch(str1, str2, next);
		System.out.println(index);
	}
	
	
	//kmp算法
	/**
	 * 
	 * @param str1 原字符串
	 * @param str2 子串
	 * @param next 子串对应的部分匹配表
	 * @return 返回第一个匹配索引位置，没有匹配到就返回-1
	 */
	public static int kmpSearch(String str1, String str2, int[] next) {
		
		for(int i = 0, j = 0; i < str1.length(); i++) {
			
			//kmp核心
			while(j > 0 && str1.charAt(i) != str2.charAt(j)) {
				j = next[j-1];
			}
			
			if(str1.charAt(i) == str2.charAt(j)) {
				j++;
			}
			if(j == str2.length()) {
				//找到了
				return i - j + 1;
			}
		}
		return -1;
	}
	
	
	//获取到一个字符串的部分匹配值表
	public static int[] kmpNext(String dest) {
		
		int[] next = new int[dest.length()];
		next[0] = 0;//如果字符串是长度为1 部分匹配值就是0
		for(int i = 1, j = 0; i < dest.length(); i++) {
			
			while(j > 0 && dest.charAt(i) != dest.charAt(j)) {
				j = next[j-1];
			}
			
			if(dest.charAt(i) == dest.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}
}
