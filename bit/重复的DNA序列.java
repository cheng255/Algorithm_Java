package com.cheng.bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author nuonuo
 * @create 2021-10-08 13:41
 */
public class 重复的DNA序列 {
    static int num1 = 786432;
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 10) {
            return res;
        }
        int i = 0;
        HashMap<Character, Integer> m1 = new HashMap<>();
        m1.put('A', 0);m1.put('C', 1);m1.put('G', 2);m1.put('T', 3);
        int sum = 0;
        while (i < 10) {
            sum = sum << 2 | m1.get(s.charAt(i++));
        }
        HashMap<Integer, Boolean> m2 = new HashMap<>();
        m2.put(sum, true);
        while (i < s.length()) {
            sum = (sum & num1 ^ sum) << 2 | m1.get(s.charAt(i++));
            //把高两位去掉，然后加上新的低两位
            if (!m2.containsKey(sum)) {
                m2.put(sum, true);
            } else if (m2.get(sum)) {
                m2.put(sum, false);
                res.add(s.substring(i-10, i));
            }
        }
        return res;
    }
}
