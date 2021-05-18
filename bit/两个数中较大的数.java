package com.cheng.bit;

/**
 * 不用任何判断找出两个数中较大的一个
 * @author nuonuo
 * @create 2021-05-17 11:44
 */
public class 两个数中较大的数 {
    public static void main(String[] args) {
        int a = 10;
        int b = 21;
        System.out.println("较大的一个 ： " + getMax(a, b));
    }

    private static int getMax(int a, int b) {
        //要考虑符号不同可能溢出的情况
        //1.如果符号相同,不会溢出
            //1.1如果a-b为正数或0，返回a,
            //1.2如果a-b为负数，返回b
        //2.符号不同，
            //2.1如果a为正数或0，返回a
            //2.2如果a为负数，返回b
        int sa = getSym(a);
        int sb = getSym(b);
        int sc = getSym(a - b);
        int difSym = sa ^ sb;
        int sameSym = negate(difSym);
        int returnA = difSym * sa + sameSym * sc;
        int returnB = negate(returnA);
        return returnA * a + returnB * b;
    }

    //得到n的符号
    private static int getSym(int n) {
        return negate((n >> 31) & 1);
    }

    //如果n为1，返回0，如果n为0，返回1
    private static int negate(int n) {
        return n ^ 1;
    }
}
