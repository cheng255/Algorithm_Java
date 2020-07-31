package com.cheng.exer2;

import java.util.Arrays;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
public class T02 {
	public static void main(String[] args) {
		String res = longestPalindrome("aaaaaa");
		System.out.println(res);
	}
	
    private static String longestPalindrome(String s) {
    	if(s == null || s.length() == 0) return null;
    	if(s.length() == 1) return s;
    	char[] s1 = s.toCharArray();
    	char[] s2 = new char[s.length()*2+1];
    	s2[0] = '#';
        for(int i = 1, j = 0; j < s.length(); i+=2, j++) {
        	s2[i] = s1[j];
        	s2[i+1] = '#';
        }
        int[] maxRadius = new int[s2.length];//记录每个字符的最大回文半径
        maxRadius[0] = 0;
        int bound = 0;//最右的回文右边界
        int left = -1, right = 1;//两个指针
        int c = 0;//中心点坐标
        int maxIndex = 0;//有最大回文半径的字符下标
        for(int i = 1; i < s2.length; i++) {
        	if(i > bound) {//暴力扩
            	left = i - 1;
            	right = i + 1;
            	while(left >= 0 && right <= s2.length-1 && s2[left] == s2[right]) {
            		left--;
            		right++;
            	}
            	if(bound < right - 1) {
                	bound = right-1;
                	c = i;
            	}

            	maxRadius[i] = right - i - 1;         	
        	}else {//判断i关于c对称的点的回文左半径和当前的最左左半径的位置关系
        		int i1 = c - (i - c);//i的对称点
        		int l = Math.abs(left+1 - i1);//c的回文右边界到i1的距离
        		if(maxRadius[i1] == l) {//同一点上，从bound下一个开始扩
        			int right1 = i + l + 1;
        			int left1 = i - l - 1;
        			while(left1 >= 0 && right1 <= s2.length-1 && s2[left1] == s2[right1]) {
                		left1--;
                		right1++;
        			}
                	maxRadius[i] = right1 - i - 1;
                	if(bound < right1 - 1) {
                    	bound = right1-1;
                    	c = i;
                    	right = right1;
                    	left = left1;
                	}
        		}else {//内或外
        			maxRadius[i] = maxRadius[i1];
        		}		
        	}   
        	if(maxRadius[maxIndex] < maxRadius[i]) {
        		maxIndex = i;
        	}
        }
        String res = String.valueOf(s2)
        		.substring(maxIndex - maxRadius[maxIndex]+1, maxIndex + maxRadius[maxIndex]);
        System.out.println(maxRadius[maxIndex]);
        return res;
    }
}
