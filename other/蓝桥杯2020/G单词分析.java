package com.cheng.other.蓝桥杯2020;

import java.util.Scanner;

/**
 * @author nuonuo
 * @create 2021-03-28 14:50
 */
public class G单词分析 {
    public static void main(String[] args) {
        int[] time = new int[26];//因为只有小写字母，所以26的长度就可以了
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for (int i = 0; i < s.length(); i++) {
            time[s.charAt(i) - 97]++;
        }
        //找到出现最多的字符就行了
        char c = s.charAt(0); int t = 0;
        for (int i = 0; i < s.length(); i++) {
            int tt = time[s.charAt(i) - 97];
            if (tt > t) {
                c = s.charAt(i);
                t = tt;
            }
        }
        System.out.println(c);
        System.out.println(t);
    }
}
