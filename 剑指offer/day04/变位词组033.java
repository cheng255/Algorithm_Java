package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。

 注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。
 示例 1:
 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 示例 2:
 输入: strs = [""]
 输出: [[""]]

    思路：就是给变位词一个hash映射，给每个词排序   排序完的词作为key

    之前做过，所以很快。
 */
public class 变位词组033 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList());
            }
            map.get(s).add(str);
        }
        List<List<String>> res = new ArrayList<>(map.values());
        return res;
    }
}
