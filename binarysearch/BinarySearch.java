package com.cheng.binarysearch;

public class BinarySearch {
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		
		int index = Binary(arr, 1);
		System.out.println(index);
	}
	
	/**
	 * 
	 * @param arr
	 * @param value
	 * @return 返回找到的值的下标， -1表示没找到
	 */
	public static int Binary(int[] arr, int value) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int middle = (left + right) / 2;
			if (value == arr[middle]) {
				return middle;
			} else if (value > arr[middle]) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return -1;
	}
	

}
