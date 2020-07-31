package com.cheng.dac;
/*
 * 
 * 分治算法实践：汉诺塔
 * 
 * 思路分析：无论有多少层，可以总是看成上面所有和最下面一层这两部分
 *  1.先将a的所有上面的盘借助c移到b
 *  2.再将a最下面的盘移到c
 *  3.再借助a将所有最上面的盘从b移到c
 * 这就是汉诺塔的递归机制
 * 
 */
public class Hanoitower {
	public static void main(String[] args) {
		hanoiTower(5, 'A', 'B', 'C');
	}
	
	public static void hanoiTower(int num, char a, char b, char c) {
		//如果只有一个盘
		if(num == 1) {
			System.out.println("第1个盘：" + a + " -> " + c);
		}else {
			hanoiTower(num - 1, a, c, b);
			System.out.println("第" + num + "个盘：" + a + " -> " + c);
			hanoiTower(num - 1, b, a, c);
		}	
	}

}
