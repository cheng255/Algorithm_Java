package com.cheng.exer;


/**
 * 
 * 问题：
 * 		给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度为o(N),
 * 		且要求不能用非基于比较的排序
 * 
 * 
 * 解答思路：有n个数，需要模拟n+1个桶，按数字大小的比例将每个数字加入到桶中
 * 			然后遍历所有桶，遇到空桶就跳过，
 * 						   遇到非空桶就找到上一个非空桶，
 * 						   让这个桶的最小值和上一个非空桶的最大值的差值记录下来
 * 			最后，最大差值就在记录的这些数中
 * 
 * 实际操作中每个桶需要三个变量， boolean类型的hasNum是否有数， int类型的最大最小值
 * 
 * @author 86182
 *
 */

public class SortProblem {
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {1,5,9,5,100,50,1,-100,1000};
		int res = maxGap(arr);	
		System.out.println(res);
		
	}
	

	private static int maxGap(int[] arr) {
		if(arr == null || arr.length < 2) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int len = arr.length;
		for(int i = 0; i < len; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
//		System.out.println("max = " + max);
//		System.out.println("min = " + min);

		if(max == min) {
			return 0;
		}
		boolean[] hasNum = new boolean[len+1];
		int[] maxs = new int[len+1];
		int[] mins = new int[len+1];
		
		int bid = 0;//用于记录当前桶
		
		for(int i = 0; i < len; i++) {
			bid = findBucket(arr[i], len, max, min);
			System.out.println(bid);
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
			hasNum[bid] = true;	
		}
		
		int lastMax = maxs[0];//上一个非空的桶中的最大数
		int res = 0;
		for(int i = 1; i <= len; i++) {
			if(hasNum[i]) {
				res = Math.max(res, mins[i]-lastMax);
				lastMax = maxs[i];
			}
		}
		return res;	
	}
	
	private static int findBucket(long number, long len, long max, long min) {
		return (int)((number-min)*len/(max-min));
	}

}
