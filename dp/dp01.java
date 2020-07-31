package com.cheng.dp;

/**
 * 
 * 判断一个数组中是否有任意累加和为k的子序列
 * @author 86182
 *
 */
public class dp01 {

	public static void main(String[] args) {
		int [] arr = {1,43,2,10,7};
		boolean sum = isSum(arr, 0, 0, 10);
		System.out.println(sum);
		boolean sumDp = isSumDP(arr, 10);
		System.out.println(sum);
	}
	
	
	private static boolean isSum(int[] arr, int i, int sum, int aim) {
		
		if(i == arr.length) {
			return sum == aim;
		}
		return isSum(arr, i+1, sum, aim) || isSum(arr, i+1, sum+arr[i], aim);
		
	}
	
	private static boolean isSumDP(int[] arr,int aim) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		if(sum < aim) {
			return false;
		}else if(sum == aim) {
			return true;
		}
		boolean[][] DpArr = new boolean[arr.length+1][sum+1];
		for(int i = 0; i < sum+1; i++) {
			if(i == aim) {
				DpArr[arr.length][i] = true;
			}else {
				DpArr[arr.length][i] = false;				
			}
		}
		
		for(int i = arr.length-1; i >= 0; i--) {
			for(int j = 0; j < sum+1-arr[i]; j++) {
				DpArr[i][j] = DpArr[i + 1][j] || DpArr[i + 1][j + arr[i]];
			}
		}
		return DpArr[0][0];
	}
	
	
	
}
