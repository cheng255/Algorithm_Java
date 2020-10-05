package com.cheng.string;

import java.util.HashMap;

/**
 * LeetCodeT13. 罗马数字转整数
 * @author nuonuo
 * @create 2020-10-05 22:13
 */
public class RomanNumeralsToIntegers {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int a, b, sum = 0;
        for (int i = 0; i < s.length(); i++) {
            a = map.get(s.charAt(i));
            if (i == s.length() - 1) {
                sum += a;
                return sum;
            }
            b = map.get(s.charAt(i + 1)); // 右侧的数
            if ((a == 1 && (b == 5 || b == 10)) ||
                    (a == 10 && (b == 50 || b == 100)) ||
                    (a == 100 && (b == 500 || b == 1000))) {
                sum += (b - a);
                i++;
            } else {
                sum += a;
            }
        }
        return sum;
    }
}
