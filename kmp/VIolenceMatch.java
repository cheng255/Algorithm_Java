package com.cheng.kmp;

public class VIolenceMatch {

	public static void main(String[] args) {
		
		String str1 = "12344 5688";
		String str2 = "45688";
		int violenceMatch = violenceMatch(str1, str2);
		System.out.println(violenceMatch);
	} 
	
	
	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return 返回子串初下标， 不匹配则返回-1
	 */
	public static int violenceMatch(String str1, String str2) {
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		for(int i = 0; i < s1.length; i++) {
			int temp = i;
			for(int j = 0; j < s2.length; j++) {
				if(temp > s1.length - 1) {
					break;
				}
				if(s1[temp] != s2[j]) {
					break;
				}else {
					temp++;
				}				
			}
			if(temp - i >= str2.length()) {
				return i;
			}
		}
		return -1;
	}
}
