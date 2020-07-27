package com.cheng.hash;
/*给定一个整数数组 nums 和一个目标值 target，
请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。*/

import java.util.Arrays;
import java.util.HashMap;

public class T01 {
	
	public static void main(String[] args) {
		int[]nums = {3,3};
		int target = 6;
		int[] twoSum = twoSum(nums, target);
		System.out.println(Arrays.toString(twoSum));
	}
	
	
    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], target-nums[i]);
            if(map.get(target-nums[i]) != null)
            {
            	res[0] = i;
            	int temp = target-nums[i];
            	for(int j = 0; j < nums.length; j++) {
            		if(i == j) continue;
            		if(nums[j] == temp)
            		{
            			res[1] = j;
            			return res;
            		}          		
            	}
            }
        }
        return res;
    }

}
