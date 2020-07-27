package com.cheng.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，
 其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
返回值小于或等于 bound 的所有强整数组成的列表。
你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
示例 1：
输入：x = 2, y = 3, bound = 10
输出：[2,3,4,5,7,9,10]
解释： 
2 = 2^0 + 3^0
3 = 2^1 + 3^0
4 = 2^0 + 3^1
5 = 2^1 + 3^1
7 = 2^2 + 3^1
9 = 2^3 + 3^0
10 = 2^0 + 3^2
提示：
1 <= x <= 100
1 <= y <= 100
0 <= bound <= 10^6
 */
public class T05 {
	public static void main(String[] args) {
		List<Integer> powerfulIntegers = powerfulIntegers(2, 3, 10);
		powerfulIntegers.forEach((t) -> {System.out.println(t);});
	}
    /*
    题目给定 x 与 y 都大于 0，因此不存在为 0 的情况
    需要注意的点：
    x 或 y 为 1 的时候，那么它的任何次幂都是 1 ，那么只需要计算一次即可
    任何数的 0 次幂都是 1，因此计算时从 1 开始
    */
    /*
    使用 a 记录 x 的 n 次幂
    使用 b 记录 y 的 n 次幂

    外层循环结束条件 a < bound，即 x 的 n 次幂最多等于 bound - 1，因为 y 的 n 次幂最少为 1
    内层循环结束条件 a + b <= bound，即 两数的幂之和超过 bound 时就退出

    两个 break 
    若 y == 1,因为它的任何次幂都是 1，那么我们内层循环 a 只需要与 它 计算一次即可
    若 x == 1 同理，只需要外层只需要计算一次即可，所有可能都在内层进行计算了
    */
    private static List<Integer> powerfulIntegers(int x, int y, int bound) {
    	
    	HashSet<Integer> set = new HashSet<>();
    	for(int a = 1; a < bound; a*=x) {
    		for(int b = 1; a+b <= bound; b*=y) {
    			set.add(a+b);
    			if(y == 1) break;
    		}
    		if(x == 1) break;
    	}  	
    	return new ArrayList<>(set);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
