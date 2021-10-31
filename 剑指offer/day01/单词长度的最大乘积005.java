package day01;

import java.util.HashMap;

/**
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 * 示例 2:
 *
 * 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 *
 * 输入: words = ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 *  
 *
 * 提示：
 *
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 * @author nuonuo
 * @create 2021-10-31 20:01
 *
 * 要记住这种题一般都往位运算和二进制思考。
 *  主要思路是 用 二进制来记录单词 比如   ac 就是 101    abc 就是  111    ad 就是  1001
 *  就可以快速判断两个单词是否有相同元素。
 *
 *  我写的版本是 用map去筛选出  像  ac 和  aac 这样的单词，只留下acc的 101和长度3
 *
 *  但看起来有点拖沓
 *
 *  看了题解，直接用数组保存每个二进制记录的单词就行了。  注意代码的观赏性
 *
 *
 */
public class 单词长度的最大乘积005 {
    public int maxProduct1(String[] words) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int n = 0;
            for (int i = 0; i < word.length(); i++) {
                n |= 1 << (word.charAt(i) - 97);
            }
            if (!map.containsKey(n) || word.length() > map.get(n)) {
                map.put(n, word.length());
            }
        }
        int res = 0;
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        for (int i = 0; i < keys.length; i++) {
            int maxKey = -1;
            int maxLen = -1;
            for (int j = i+1; j < keys.length; j++) {
                if ((keys[j] & keys[i]) == 0 && map.get(keys[j]) > maxLen) {
                    maxKey = keys[j];
                    maxLen = map.get(maxKey);
                }
            }
            maxLen = map.get(keys[i]) * maxLen;
            if (maxLen > res) {
                res = maxLen;
            }
        }
        return res;
    }

    public int maxProduct2(String[] words) {
        int[] nums = new int[words.length];
        int index = 0;
        for (String word : words) {
            int n = 0;
            for (int i = 0; i < word.length(); i++) {
                n |= 1 << (word.charAt(i) - 97);
            }
            nums[index++] = n;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if ((nums[j] & nums[i]) == 0) {
                    res = Math.max(res, words[j].length() * words[i].length());
                }
            }
        }
        return res;
    }
}
