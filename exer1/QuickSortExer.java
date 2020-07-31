package com.cheng.exer1;

import java.util.Arrays;


//练习快排    
public class QuickSortExer {
	
	public static void main(String[] args) {
		int[] arr = {1,6,2,1,10,7,7,0,2,3,1,6};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int left, int right) {
		if(left < right) {
			//以left为快排的point（基）值随机point值，使得算法更加优质
			swap(arr,left + (int) Math.random() * (right - left + 1), left);
			int[] res = patition(arr, left, right);
			quickSort(arr, left, res[0]);
			quickSort(arr, res[1], right);
		}
		
	}
	
	
	private static int[] patition(int[] arr, int left, int right) {
		int less = left - 1;//小于point的部分
		int more = right + 1;//大于point的部分
		int point = arr[left];
		while(left < more) {
			if(arr[left] < point) {
				swap(arr, ++less, left++);
			}else if(arr[left] > point) {
				swap(arr, --more, left);
			}else {
				left++;
			}
		}
		return new int[] {less, more};
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
