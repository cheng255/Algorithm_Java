package com.cheng.hash;

import java.util.HashSet;

//编写一个算法来判断一个数 n 是不是快乐数。
//
//「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程
//直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
//
//如果 n 是快乐数就返回 True ；不是，则返回 False 。
public class T03 {

	public static void main(String[] args) {
		boolean happy = isHappy(19);
		System.out.println(happy);
	}
	
    private static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int num = n;
        set.add(num);
        while(true) {
        	if(num == 1) return true; 
        	int temp = 0;
        	while(num != 0) {     		
        		temp += (num % 10) * (num % 10);
        		num /= 10;
        	}
        	num = temp;  
        	if(set.contains(num))
        		return false;
        	else
        		set.add(num);
        }
    }
}
