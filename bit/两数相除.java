package com.cheng.bit;

/**
 * LeetCode22 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * @author nuonuo
 * @create 2021-05-17 22:43
 */
public class 两数相除 {
    public static void main(String[] args) {

    }
    public int divide(int dividend, int divisor) {
        long dd = dividend;
        long rr = divisor;
        boolean sameSym = false;//符号是否相同
        if ((dd > 0 && rr > 0) || (dd < 0 && rr < 0)) {
            sameSym = true;
        }
        dd = Math.abs(dd);
        rr = Math.abs(rr);
        if (rr == 1) {
            if (dd > Integer.MAX_VALUE) {
                return sameSym ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            return (int)(sameSym ? dd : -dd);
        }
        long res = 0;
        long d = dd;
        long r = rr;
        while (d >= r) {
            long t = 0;//
            while (d >= r) {
                t = t == 0 ? 1 : t + t;
                r <<= 1;
            }
            res += t;
            if (d == r) {//够了
                break;
            }
            //如果没除够，剩下的继续除
            d = d - (r >> 1);
            r = rr;
        }
        return (int)(sameSym ? res : -res);

    }
}
