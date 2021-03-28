package com.cheng.other.蓝桥杯2014;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 小明先把硬币摆成了一个 n 行 m 列的矩阵。
 * 随后，小明对每一个硬币分别进行一次 Q 操作。
 * 对第x行第y列的硬币进行 Q 操作的定义：将所有第 i*x 行，第 j*y列的硬币进行翻转。
 * 其中i和j为任意使操作可行的正整数，行号和列号都是从1开始。
 * 当小明对所有硬币都进行了一次 Q 操作后，他发现了一个奇迹——所有硬币均为正面朝上。
 * 小明想知道最开始有多少枚硬币是反面朝上的。于是，他向他的好朋友小M寻求帮助。
 * 聪明的小M告诉小明，只需要对所有硬币再进行一次Q操作，即可恢复到最开始的状态。然而小明很懒，不愿意照做。于是小明希望你给出他更好的方法。帮他计算出答案。
 * 【样例输入】
 * 2 3
 * 【样例输出】
 * 1
 * 【数据规模】
 * 对于10%的数据，n、m <= 10^3；
 * 对于20%的数据，n、m <= 10^7；
 * 对于40%的数据，n、m <= 10^15；
 * 对于10%的数据，n、m <= 10^1000（10的1000次方）。
 *
 *
 * 经过分析实际上是求n中的平方数*m中的平方数  ->   对n和m开方
 *
 *
 * @author nuonuo
 * @create 2021-03-22 10:31
 */
public class 矩阵翻硬币 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        String m = sc.next();
        System.out.println(sqrt(n).multiply(sqrt(m)));

    }
    //1.首先找到开方后的数的位数，
    //2.然后枚举出这个数，并用pow（2）来和n比较
    private static BigInteger sqrt(String n) {
        int len = n.length();//n的位数
        int sqrtLen = (len & 1) == 1 ? len / 2 + 1 : len / 2;//n开方后的位数
        char[] num = new char[sqrtLen];//用来尝试找到开方后的数
        BigInteger value = new BigInteger(n);
        Arrays.fill(num, '0');
        for (int i = 0; i < sqrtLen; i++) {
            for (char j = '1'; j <= '9'; j++) {
                num[i] = j;
                BigInteger expectedPow = new BigInteger(String.valueOf(num));
                if (expectedPow.pow(2).compareTo(value) > 0) {
                    //预期的值平方比真实值大,就将这一位-1,代表这一位符合要求了，break取预期下一位
                    num[i]--;
                }
                if (expectedPow.pow(2).compareTo(value) >= 0) {
                    //相等，就返回结果
                    break;
                }
                //小于就继续
            }
        }
        return new BigInteger(String.valueOf(num));
    }


}
