package exer05;

/**
 * 剑指offer42题：反转单词顺序 VS 左旋转字符串
 * @author nuonuo
 * @create 2020-08-03 13:20
 */
public class T42 {
}

/**
 * 左旋转字符串
 * 题目描述：汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
/*
1.我的想法，使用StringBuilder
 */
class Solution5 {
    public static void main(String[] args) {
        String str = "abcdefg";
        String s = new Solution5().LeftRotateString(str, 3);
        System.out.println(s);
    }
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < n; i++) {
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }
        return new String(sb);
    }
}
/*
2.第二种解法，使用reverse反转字符串  比如abcdefg  要想反转前三个
            1.将字符串分为两部分 abc 和 defg
            2.将两部分分别反转 得到 cba gfed
            3.再将整个字符串反转  得到 defgabc
 */
class Solution6 {
    public static void main(String[] args) {
        String str = "abcdefg";
        String s = new Solution6().LeftRotateString(str, 3);
        System.out.println(s);
    }
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n < 0) {
            return "";
        }
        StringBuilder sb1 = new StringBuilder(str.substring(0, n));
        StringBuilder sb2 = new StringBuilder(str.substring(n));
        sb1.reverse();
        sb2.reverse();
        StringBuilder sb = sb1.append(sb2);
        sb.reverse();
        return new String(sb);
    }
}

/**
 * 反转单词顺序
 * 题目描述：例如，“student. a am I”。正确的句子应该是“I am a student.”
 */

/*
    思路：还是利用reverse的思路
    1.将字符串整个反转  student. a am I ->  I ma a .tneduts
    2.将每个单词反转  I ma a .tneduts -> I am a student.
 */
class Solution7 {
    public static void main(String[] args) {
        String s = new Solution7().ReverseSentence("  ");
        System.out.println(s);
    }
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String s = new String(sb);//全部反转之后的字符串
        String[] split = s.split(" ");
        if (split.length == 0) { //如果全部都是空格，就返回str本身引用
            return str;
        }
        StringBuilder res = new StringBuilder();
        for (String s1 : split) {
            res.append(new StringBuilder(s1).reverse()).append(" ");
        }
        return new String(res.deleteCharAt(res.length()-1));
    }
}