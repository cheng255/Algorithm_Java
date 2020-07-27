package com.cheng.hash;

import java.util.HashMap;

//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//说明：
//你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
public class T02 {

	public static void main(String[] args) {
		int[] arr = {4,1,2,1,2};
		int singleNumber = singleNumber1(arr);
		System.out.println(singleNumber);
	}
	//哈希表解法（不满足要求）
    private static int singleNumber(int[] nums) {
    	HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
    	int res = 0;
    	for(int num : nums) {
    		if(map.get(num) == null) {
    			map.put(num, 1);
    		}else {
    			map.put(num, map.get(num)+1);
    		}		
    	}
    	for(int num : nums) {
    		if(map.get(num) == 1) {
    			res = num;
    			break;
    		}
    	}
    	return res;
    }
    //位运算
    private static int singleNumber1(int[] nums) {
    	int res = 0;
    	for(int num : nums) {
    		res ^= num;
    	}
    	return res;
    }
	
	
}
