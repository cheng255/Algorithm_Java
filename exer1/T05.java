package com.cheng.exer1;

import java.util.HashMap;

/*给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
注意:
假设字符串的长度不会超过 1010。
示例 1:
输入:
"abccccdd"
输出:
7
解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。*/
public class T05 {
	
	public static void main(String[] args) {
		int longestPalindrome = longestPalindrome("civilwartestingwhetherthatna"
				+ "ptionoranynartionsoconceivedandsodedicatedcanlongendureWeareq"
				+ "metonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportio"
				+ "nofthatfieldasafinalrestingplaceforthosewhoheregavetheirlives"
				+ "thatthatnationmightliveItisaltogetherfangandproperthatweshoul"
				+ "ddothisButinalargersensewecannotdedicatewecannotconsecratewec"
				+ "annothallowthisgroundThebravelmenlivinganddeadwhostruggledher"
				+ "ehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworl"
				+ "dadswfilllittlenotlenorlongrememberwhatwesayherebutitcannever"
				+ "forgetwhattheydidhereItisforusthelivingrathertobededicatedher"
				+ "etotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonobly"
				+ "advancedItisratherforustobeherededicatedtothegreattdafskremai"
				+ "ningbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiont"
				+ "othatcauseforwhichtheygavethelastpfullmeasureofdevotionthatw"
				+ "eherehighlyresolvethatthesedeadshallnothavediedinvainthatthi"
				+ "snationunsderGodshallhaveanewbirthoffreedomandthatgovernment"
				+ "ofthepeopleby"
				+ "thepeopleforthepeopleshallnotperishfromtheearth");
		System.out.println(longestPalindrome);
	}
	//字母阿斯克码是65-90和97-122
    private static int longestPalindrome(String s) {
    	if(s == null || s.length() == 0 || s.length() == 1) return s.length();
    	int[] times = new int[123];//字符出现次数
    	int len1 = s.length();
    	int len2 = times.length;
    	int res = 0;
    	char c;
    	for(int i = 0; i < len1; i++) {
    		c = s.charAt(i);
    		times[c]++;
    	} 	
    	boolean flag = false;
    	for(int i = 65; i < len2; i++) {
    		if(times[i] % 2 == 0) {//偶数
    			res += times[i];
    		}else {
    			flag = true;
    			res += (times[i]-1);//奇数
    		}
    	}
    	if(flag) res += 1;	
    	return res;
    }

}
