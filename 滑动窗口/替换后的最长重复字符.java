package com.cheng.滑动窗口;

/**
 * 424. 替换后的最长重复字符
 * @author nuonuo
 * @create 2021-10-01 13:15
 */
public class 替换后的最长重复字符 {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int l = 0, r = 0;
        int maxCountIndex = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            arr[c-65]++;
            if (arr[c-65] > arr[maxCountIndex]) {
                maxCountIndex = c - 65;
            }
            if (r - l + 1 - arr[maxCountIndex] > k) {//非第一多的字母数量超过了k
                arr[s.charAt(l)-65]--;
                l++;
            }
            r++;

        }
        return r - l;

    }
}
