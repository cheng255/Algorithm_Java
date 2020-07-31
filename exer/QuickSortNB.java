package com.cheng.exer;

import java.util.Arrays;

public class QuickSortNB {

	public static void main(String[] args) {
		int[] arr = {5,3,2,9,10,1,2,4};
		
		quickSort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
		
	}

	private static void quickSort(int[] arr, int L, int R) {
		
		if(L < R) {
			swap(arr, L + (int)(Math.random() * (R - L + 1)), R);
			int[] par = partition(arr, L, R);
			quickSort(arr, L, par[0] - 1);
			quickSort(arr, par[1] + 1, R);
		}
		
	}
	
	
	private static int[] partition(int[] arr, int L, int R) {
		int less = L-1;
		int more = R;
		while(L < more) {
			if(arr[L] < arr[R]) {
				swap(arr, ++less, L++);
			}else if(arr[L] > arr[R]){
				swap(arr, --more, L);
			}else {
				L++;
			}
		}
		swap(arr, R, more);
		
		return new int[] {less + 1, more};
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	
	
}
