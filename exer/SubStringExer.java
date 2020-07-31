package com.cheng.exer;
/**
 * 
 * 找字符相同，不同序列的子序列
 * 
 * @author 86182
 *
 */
public class SubStringExer {

	public static void main(String[] args) {
		
		String arr1 = new String("abcdjfkashf");
		String arr2 = new String("ahs");
		
		int res = func(arr1,arr2);
		System.out.println(res);
		
	}

	/**
	 * 
	 * @param arr1 
	 * @param arr2 子串
	 */
	private static int func(String arr1, String arr2) {
		
		char[] c1 = arr1.toCharArray();
		char[] c2 = arr2.toCharArray();
		
		int len = arr2.length();
		
		//先根据子串建立欠债表
		char[] count = new char[256];

		for(int i = 0; i < len; i++) {
			count[ c2[i]  ]++;
		}
		int illegalTime = 0;//不合法的次数
		int M = 0;//帮助遍历
		//先让窗口中放入第一批字符
		for(; M < len; M++) {
			if(count[ c1[M] ]-- <= 0) {
				illegalTime++;
			}
		}
		//此时第一次匹配完成，M=len，既是完成了 0---len-1 
		//之后依次完成 1---len   2---len+1
		for(; M < arr1.length(); M++) {
			
			if(illegalTime == 0) {
				return M - len;
			}
			if(count[ c1[M]  ]-- <= 0) {
				illegalTime++;
			}
			if(count[ c1[M-len] ]++ <= 0) {
				illegalTime--;
			}
		}
		//判断最后一批是否符合
		return illegalTime == 0 ? M-len : -1;
		
	
	}
	
	
	
	
	
	
	
	
}
