package com.cheng.hash;

import java.util.LinkedList;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//示例 1:
//输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//示例 2:
//输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
public class T07 {

	public static void main(String[] args) {
		int lengthOfLongestSubstring = lengthOfLongestSubstring("bbbbbbbbbbbbbbbbbbbbbbbbb");
		System.out.println(lengthOfLongestSubstring);
	}
	
    private static int lengthOfLongestSubstring(String s) {
    	LinkedList<Character> sw = new LinkedList<>();
    	int max = 0;   	
    	for(int i = 0; i < s.length(); i++) {
    		char temp = s.charAt(i);
    		if(sw.contains(temp)) {
    			while(!sw.isEmpty() && sw.removeFirst() != temp) {}
    		}  			
    		sw.addLast(temp);
    		max = (sw.size() > max) ? sw.size() : max;
    	}    	
    	return max;
    	
    }
    
    
    
    
    
    
    
}
