package day02;

import java.util.Arrays;

/**
 * @author nuonuo
 * @create 2021-11-08 17:32
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 * 示例 1：
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 思路： 就是双指针 滑动窗口     自己写的太废话了      看了题解才改的好看一点   下次在做！！！
 */
public class 字符串中的变位词014 {
    //看了题解修改的
    public boolean checkInclusion2(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] t = new int[26];
        int nums = 0;
        char c;
        for (int i = 0; i < s1.length(); i++) {
            c = s1.charAt(i); t[c-97]++;
        }
        for (int r = 0, l = 0; r < s2.length(); r++) {
            c = s2.charAt(r);
            t[c-97]--;
            while (t[c-97] < 0) {//多了
                t[s2.charAt(l)-97]++;
                l++;
            }
            if (s1.length() == r - l + 1) {
                return true;
            }
        }
        return false;
    }

    //自己写的
    public boolean checkInclusion1(String s1, String s2) {
        int[] t = new int[26];
        Arrays.fill(t, -1);
        int nums = 0;
        char c;
        for (int i = 0; i < s1.length(); i++) {
            c = s1.charAt(i);
            t[c-97] = t[c-97] == -1 ? 1 : t[c-97]+1;
            if (t[c-97] == 1) {
                nums++;
            }
        }
        int temp = 0;
        int l = 0, r = 0;
        while (r < s2.length()) {
            c = s2.charAt(r);
            if (t[c-97] == -1) {
                while (l <= r) {
                    c = s2.charAt(l);
                    if (t[c-97] != -1) {
                        if (t[c-97] == 0) temp--;
                        t[c-97]++;
                    }
                    l++;
                }
                r++; continue;
            }
            t[c-97]--;
            if (t[c-97] >= 0) {
                if (t[c-97] == 0) {
                    temp++;
                    if (temp == nums) {
                        return true;
                    }
                }
                r++;
                continue;
            }
            while (t[c-97] < 0) {
                if (t[s2.charAt(l)-97] == 0) temp--;
                t[s2.charAt(l)-97]++;
                l++;
            }
            r++;
        }
        return false;
    }

}
