package com.cheng.trie;

import java.util.HashMap;

/*实现一个 MapSum 类里的两个方法，insert 和 sum。
对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，
那么原来的键值对将被替代成新的键值对。
对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
示例 1:
输入: insert("apple", 3), 输出: Null
输入: sum("ap"), 输出: 3
输入: insert("app", 2), 输出: Null
输入: sum("ap"), 输出: 5*/
public class T02 {
	public static void main(String[] args) {
		MapSum mapSum = new MapSum();
		mapSum.insert("aa", 3);
		System.out.println(mapSum.sum("a"));//3
		mapSum.insert("aa", 2);
		System.out.println(mapSum.sum("a"));//2
	}
}

class MapSum {
	TrieNode root;//头结点
	HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public MapSum() {
    	root= new TrieNode();
    	map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
    	if(key == null || key.length() == 0) {
    		return;
    	}
    	int preValue = 0;//之前的键值
    	if(map.containsKey(key)) {
    		preValue = map.get(key);
    	}
    	map.put(key, val);
    	char[] keys = key.toCharArray();
    	TrieNode temp = root;//辅助变量
    	for(char k : keys) {//依次将字符插入到当前结点的next集合里
    		if(temp.path == 0 || !temp.next.containsKey(k)) {
    			temp.next.put(k, new TrieNode());
    		}
    		temp.path++;//当前结点路径条数加一
    		temp.values += val;//当前的结点values+val
    		temp.values -= preValue;//当前的结点values-preValue
    		temp = temp.next.get(k);   		
    	}
    	//将最后一个结点的path和end++，value值+val
    	temp.end++;
    	temp.path++;
    	temp.values += val;
    	temp.values -= preValue;
    }
    
    public int sum(String prefix) {
    	//先匹配到prefix的最后一个字符， 然后遍历到以下的每个结点，并加上value值
    	char[] pres = prefix.toCharArray();
    	TrieNode temp = root;//辅助变量
    	for(char p : pres) {
    		if(temp.path == 0 || !temp.next.containsKey(p)) {
    			return 0;
    		}
    		temp = temp.next.get(p);
    	}
    	//此时temp结点就是前缀字符串最后的一个结点
    	return temp.values;   	
    }
}

class TrieNode {
	int values;//经过该节点的键值和
	int path;//有多少经过该点的字符串
	int end;//以该节点结尾的字符换有多少
	HashMap<Character, TrieNode> next;//结点的next集合
	
	
	TrieNode(){
		values = 0;
		path = 0;
		end = 0;
		next = new HashMap<>();	
	}
}