package com.cheng.lanqiao20;

import java.math.BigInteger;

public class T3 {
	public static void main(String[] args) {
		BigInteger num = new BigInteger("1");
		for (int i = 1; i <= 10; i++) {
			num = num.multiply(new BigInteger(i+""));
		}
		System.out.println(num);
		BigInteger res = getNumber(num);
		System.out.println("long -> " + num.longValue());
		long res1 = getNumber(num.longValue());
		System.out.println(res);
		System.out.println(res1);
	}
	
	/**
	 * 求n的约数个数的模板
	 * @param num
	 * @return
	 */
	private static long getNumber(long num) {
		long res = 1;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			long n = 1;
			while ((num % i) == 0) {
				n++;
				num /= i;
			}
			res *= n;
		}
		return num > 1 ? res * 2 : res;
	}

	//求num的约数
	private static BigInteger getNumber(BigInteger num) {
		BigInteger res = BigInteger.ONE;
		BigInteger n = null;
		BigInteger one = BigInteger.ONE;
		for (BigInteger i = new BigInteger("2"); i.multiply(i).compareTo(num) <= 0; i = i.add(one)) {
			n = BigInteger.ONE;
			while (num.mod(i).equals(BigInteger.ZERO)) {
				n = n.add(one);
				num = num.divide(i);
			}
			if (n.compareTo(one) > 0) {
				res = res.multiply(n);
			}
		}

		return num.compareTo(one) > 0 ? res.multiply(new BigInteger("2")) : res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//模板
//	 public static int factors(long n) {
//	        int res = 1, now;
//	        for (int i = 2; i * i <= n; i++) {//首先找到小于根号n的所有质数，
//	            now = 1;
//	            while (n % i == 0) {
//	                n /= i;
//	                now++;
//	            }
//	            if (now > 1)
//	                res *= now;
//	        }
//	        System.out.println(n);
//	        return n > 1? res *2 : res;
//	    }
	 //约数个数定理
}
