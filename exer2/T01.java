package com.cheng.exer2;

import java.util.Arrays;
import java.util.LinkedList;


//窗口内最大值
public class T01 {
	public static void main(String[] args) {
		int[] arr = new int[] {2,6,8,2,7,1,8,2,10};
		int[] res = maxWindows(arr, 3);
		System.out.println(Arrays.toString(res));
	}

	private static int[] maxWindows(int[] arr, int k) {
		if(arr == null || k < 1 || arr.length < k) return null;
		LinkedList<Integer> list = new LinkedList<>();
		int[] res = new int[arr.length - k + 1];
		int index = 0;
		for(int i = 0; i < arr.length; i++) {
			while(!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
				list.pollLast();
			}
			list.addLast(i);
			if(i - k == list.peekFirst()) {
				list.pollFirst();
			}
			if(i >= k - 1) {
				res[index++] = arr[list.peekFirst()];			
			}
		}
		
		return res;
	}
}
