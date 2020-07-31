package com.cheng.trie;
/*实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
示例:
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");   
trie.search("app");     // 返回 true
说明:
你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。*/

import java.util.HashMap;

public class T01 {
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // 返回 true
		System.out.println(trie.search("app"));     // 返回 false
		System.out.println(trie.startsWith("app")); // 返回 true
		trie.insert("app");   
		System.out.println(trie.search("app"));     // 返回 true
	}
}
class Node {
	int path;//经过这个结点的字符串的个数
	int end;//以这个节点结尾的字符串的个数
	HashMap<Character, Node> next;
	
	Node(){
		path = 0;
		end = 0;
		next = new HashMap<>();
	}
	
}
class Trie {
	
	Node root;//头节点
	
    /** Initialize your data structure here. */
    public Trie() {
    	root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	if(word == null || word.length() == 0) {
    		return;
    	}
    	Node temp = root;
    	for(int i = 0; i < word.length(); i++) {
    		char c = word.charAt(i);
    		if(!temp.next.containsKey(c)) {
    			temp.next.put(c, new Node());//将字符加入到当前结点的next中
    		}  		
    		temp.path++;//对当前头节点的path加一
    		temp = temp.next.get(c);//换到下一个结点,遍历
    	}
    	//将最后一个node的end和path++
    	temp.path++;
    	temp.end++;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	if(word == null || word.length() == 0) {
    		return false;
    	}
    	Node temp = root;
    	for(int i = 0; i < word.length(); i++) {
    		char c = word.charAt(i);
    		//如果当前路不通或者next中没有当前字符 返回false
    		//如果有当前字符，判断下一个，直到最后一个的字符的end值>0,返回false
    		if(!temp.next.containsKey(c)) {
    			return false;
    		}
    		temp = temp.next.get(c);
    	}
    	if(temp.end > 0) {
    		return true;
    	}
    	return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	if(prefix == null || prefix.length() == 0) {
    		return false;
    	}
    	Node temp = root;
    	for(int i = 0; i < prefix.length(); i++) {
    		char c = prefix.charAt(i);
    		//如果当前路不通或者next中没有当前字符返回false
    		//如果有判断下一个，最后一个字符也存在，就返回false
    		if(!temp.next.containsKey(c)) {
    			return false;
    		}
    		temp = temp.next.get(c);
    	}
    	return true; 	
    }
}
