package com.cheng.hash;
/*给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，
该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，
则返回答案中字典序最小的单词。若无答案，则返回空字符串。
示例 1:
输入: 
words = ["w","wo","wor","worl", "world"]
输出: "world"
解释: 
单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
示例 2:
输入: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
输出: "apple"
解释: 
"apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
注意:
所有输入的字符串都只包含小写字母。
words数组长度范围为[1,1000]。
words[i]的长度范围为[1,30]。*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T06 {
	public static void main(String[] args) {
		String longestWord = longestWord(new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"});
		System.out.println(longestWord.toString());
	}
	
    private static String longestWord(String[] words) {
    	//先把单词都放在set中
    	Set<String> dict = new HashSet<>();
    	for(String word : words) {
    		dict.add(word);
    	}
    	//将数组中单词按照长度升序再字母降序的方式排序
    	Arrays.sort(words, (a, b) -> {
    		if(a.length() != b.length()) {
    			return a.length() - b.length();
    		}else {
    			return b.compareTo(a);
    		}
    	});
    	//从后往前遍历找第一个有所有前缀的单词
    	for(int i = words.length-1; i >= 0; i--) {
    		if(buildWord(dict, words[i])) {
    			return words[i];
    		}
    	}
    	return "";
    }
	private static boolean buildWord(Set<String> dict, String word) {
		for(int i = 1; i < word.length(); i++) {
			if(!dict.contains(word.substring(0, i))) {
				return false;
			}
		}
		return true;
	}

	
	
	
	
	
	
	
	
	
	
}
