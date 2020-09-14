package com.cheng.string;

import java.util.*;

/**
 * LeetCode T49. 字母异位词分组
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @author nuonuo
 * @create 2020-09-13 18:10
 */
public class LetterDysphoricGrouping {
    public static void main(String[] args) {
        List<List<String>> lists = groupAnagrams(new String[]{"ddddddddddg","dgggggggggg"});
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

    // 维护一个映射 ans : {String -> List}，其中每个键是一个排序字符串，每个值是初始输入的字符串列表
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String s = Arrays.toString(temp);
            if (map.isEmpty() || !map.containsKey(s)) { // map为空或者没有该类字符串
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(s, list);
                continue;
            }// map 包含该类字符串
            map.get(s).add(strs[i]);
        }
        Collection<List<String>> values = map.values();
        Iterator<List<String>> iterator = values.iterator();
        while (iterator.hasNext()) {
            Collections.sort(iterator.next());
        }
        res.addAll(values);
        res.sort((Comparator.comparingInt(List::size)));
        return res;
    }

}
