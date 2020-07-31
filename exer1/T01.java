package com.cheng.exer1;

import java.util.Arrays;
import java.util.HashMap;

/*人们会互相发送好友请求，现在给定一个包含有他们年龄的数组，ages[i] 表示第 i 个人的年龄。

当满足以下条件时，A 不能给 B（A、B不为同一人）发送好友请求：

age[B] <= 0.5 * age[A] + 7
age[B] > age[A]
age[B] > 100 && age[A] < 100
否则，A 可以给 B 发送好友请求。
注意如果 A 向 B 发出了请求，不等于 B 也一定会向 A 发出请求。而且，人们不会给自己发送好友请求。 
求总共会发出多少份好友请求?*/
/*说明:
1 <= ages.length <= 20000.
1 <= ages[i] <= 120.*/

public class T01 {
	
	public static void main(String[] args) {
		int[] arr = new int[] {108,115,5,24,82}; 
		
		int numFriendRequests = numFriendRequests(arr);
		System.out.println(numFriendRequests);
	}
    private static int numFriendRequests(int[] ages) {
    	int[] counts = new int[121];
    	for(int age : ages) { counts[age]++; }//得到每个年龄的人数
    	int sum = 0;
    	
    	for(int i = 1; i <= 120; i++) {
    		
    		for(int j = 1; j <= 120; j++) {
    			if(j <= i*0.5+7 || j > i || j > 100 && i < 100) {
    				continue;
    			}   			
    			sum+= (i != j) ? counts[i]*counts[j] : counts[i]*(counts[i]-1);
    		}
    	}
    	return sum;
    }

    
    
    
    
    
    
    
    
    
  
}
