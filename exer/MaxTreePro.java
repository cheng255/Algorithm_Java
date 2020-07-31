package com.cheng.exer;

import java.util.TreeSet;

/**
 * 
 * 题目：构造数组的MaxTree
 * 
 * 一个数组的MaxTree定义如下：
 * 		数组必须没有重复元素
 * 		MaxTree是一棵二叉树， 数组的每一个值对应一个二叉树结点
 * 		包括MaxTree树在内且在其中的每一棵子树上，值最大的结点都是树的头
 * 		
 * 	给定没有重复元素的数组arr，写出生成这个数组的MaxTree的函数， 要求如果数组长度为N，
 * 				 则时间复杂度为O(N)  则空间复杂度为O(N)
 * 
 * 
 * @author 86182
 *
 */
public class MaxTreePro {

	
	public static void main(String[] args) {
		
		int[] arr = {7, 3, 5, 9, 15, 1, 6, 8, 10, 13};
		
		TreeSet<Node> treeSet = new TreeSet<Node>();
		for(int i = 0; i < arr.length; i++) {
			treeSet.add(new Node(arr[i]));			
		}
		for (Node node : treeSet) {
			System.out.println(node);
		}
	}
	
	private static void getMaxTree(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			
			
			
			
			
			
		}
		
		
	}
	
}


class Node implements Comparable<Node>{
	
	public int value;
	public Node left;
	public Node right;
	
	public Node(int value) {
		this.value = value;
	}

	@Override
	public int compareTo(Node o) {
		return this.value-o.value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
	
	
}

