package com.cheng.exer1;

import java.util.Arrays;
import java.util.HashMap;

/*给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串
 str 中的每个非空单词之间存在着双向连接的对应规律。
示例1:
输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例 2:
输入:pattern = "abba", str = "dog cat cat fish"
输出: false
示例 3:
输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
示例 4:
输入: pattern = "abba", str = "dog dog dog dog"
输出: false
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。  
*/
public class T04 {
	
	
	public static void main(String[] args) {
		boolean wordPattern = wordPattern("abba", "dog cat cat dog");
		System.out.println(wordPattern);
	}
    private static boolean wordPattern(String pattern, String str) {
        String[] splitStr = str.split(" ");
        int len = pattern.length();
        int len1 = splitStr.length;
    	if(len != len1) return false;
        HashMap<Character, String> map = new HashMap<>();//字母映射字符串
        for(int i = 0; i < len; i++) {
        	char c = pattern.charAt(i);
        	if(map.containsKey(c)) {
        		if(!map.get(c).equals(splitStr[i])) {
        			return false;
        		}
        	}else {
        		if(map.containsValue(splitStr[i])) {
        			return false;
        		}
        		map.put(c, splitStr[i]);
        	}
        }
        return true;
    }

}
