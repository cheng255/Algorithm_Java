package com.cheng.exer;

/**
 * 
 * 窗口内最大最小值更新结构
 */

import java.util.Arrays;
import java.util.LinkedList;

public class maxSlidingWindowPro {
	
	public static void main(String[] args) {
		int[] arr = {1,3,-1,-3,5,3,6,7};
		int[] res = maxSlidingWindow(arr, 3);
		System.out.println(Arrays.toString(res));
	}
	
	private static int[] maxSlidingWindow(int[] arr, int k) {
		
		LinkedList<Integer> list = new LinkedList<>();
		int[] slidingMaxArr = new int[arr.length-k+1];
		int index = 0;
		for(int i = 0; i < arr.length; i++) {
			while(!list.isEmpty() && arr[list.peekLast()] <= arr[i]) {
				list.pollLast();
			}
			list.addLast(i);
			
			if(list.peekFirst() == i - k) {
				list.pollFirst();
			}
			if(i+1 >= k) {
				slidingMaxArr[index++] = arr[list.peekFirst()];
			}
		}
		return slidingMaxArr;
	}

}
