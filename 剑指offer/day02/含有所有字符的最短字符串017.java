package day02;

import java.util.HashMap;

/**
 给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。

 如果 s 中存在多个符合条件的子字符串，返回任意一个。

  

 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。

  

 示例 1：

 输入：s = "ADOBECODEBANC", t = "ABC"
 输出："BANC"
 解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C'
 示例 2：

 输入：s = "a", t = "a"
 输出："a"
 示例 3：
 输入：s = "a", t = "aa"
 输出：""
 解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。

 提示：

 1 <= s.length, t.length <= 105
 s 和 t 由英文字母组成

 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？

 思路： O(n2)的方法很简单     hash表存储  然后每一轮去检查是否符号t的hash表
        O(n)的方法
                1：我写的版本  很繁琐   用了一个变量sum来记录t中不同字符的个数
                    滑动窗口移动， 每当有一个新的字符满足要求，temp就加1 ，当加到temp==sum,说明这个串符合要求，
                    再将left指针移动到合理位置就好。
                2.看了题解  记录s中大的有效字符，也就是滑动窗口中  t中需要的字符数量
                            当有效字符数量等于map.size时说明合法，。


        总结：   一种方法是保存不同的字符的个数   另一种是保存有效字符的个数
            第二种方法代码更加简洁


 */
public class 含有所有字符的最短字符串017 {
    public String minWindow(String s, String t) {
        int resL = 0;
        int resR = -1;
        HashMap<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int n = mapT.getOrDefault(t.charAt(i), 0);
            mapT.put(t.charAt(i), n-1);
        }
        int l = 0, r = 0, temp = 0;//temp表示有效字符的数量
        while (r < s.length()) {
            if (mapT.getOrDefault(s.charAt(r), 0) < 0) {
                temp++;
            }
            mapT.put(s.charAt(r), mapT.getOrDefault(s.charAt(r), 0)+1);
            if (temp == t.length()) {//有效字符足够
                while (mapT.getOrDefault(s.charAt(l), 0) > 0) {
                    mapT.put(s.charAt(l), mapT.getOrDefault(s.charAt(l), 0)-1);
                    l++;
                }
                if (resR == -1 || r - l < resR - resL) {
                    resL = l;
                    resR = r;
                }
            }
            r++;
        }
        return s.substring(resL, resR+1);
    }


    public String minWindow1(String s, String t) {
        int resL = 0;
        int resR = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int n = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), n-1);
        }
        //System.out.println(map);
        int l = 0, r = 0;
        int temp = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                int n = map.get(c)+1;
                map.put(c, n);
                if (n == 0) {//这个字符正好够了
                    temp++;
                    if (temp == map.size()) {//所有字符都够了
                        while (!map.containsKey(s.charAt(l)) || map.get(s.charAt(l)) > 0) {
                            if (map.containsKey(s.charAt(l))) {
                                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                            }
                            l++;
                        }
                        if (resR == -1 || r - l < resR - resL) {
                            resL = l;
                            resR = r;
                        }
                        //System.out.println("l = " + l + ", r = " + r);
                        map.put(s.charAt(l), map.get(s.charAt(l))-1);
                        l++;
                        temp--;
                    }
                }
            }
            r++;
        }
        return s.substring(resL, resR+1);
    }
}
