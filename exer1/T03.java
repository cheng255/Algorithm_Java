package com.cheng.exer1;
//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
//使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

import java.util.HashMap;

public class T03 {
	public static void main(String[] args) {
		boolean b = containsNearbyDuplicate(new int[] {1,0,1,1}, 1);
		System.out.println(b);
	}
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length == 1) return false;
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();//存值和下标
        boolean flag = false;
        for(int i = 0; i < len; i++){
            if(map.containsKey(nums[i])){//有该值
                if(Math.abs( map.get(nums[i]) - i ) <= k){//满足要求
                    flag = true;
                }else {
                	map.put(nums[i], i);
                }
            }else{//没有该值
                map.put(nums[i], i);
            }
        }
        return flag;
    }
}
