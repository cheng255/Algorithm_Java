package day06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：

 words.length == indices.length
 助记字符串 s 以 '#' 字符结尾
 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
 给定一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。
 示例 1：

 输入：words = ["time", "me", "bell"]
 输出：10
 解释：一组有效编码为 s = "time#bell#" 和 indices = [0, 2, 5] 。
 words[0] = "time" ，s 开始于 indices[0] = 0 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 words[1] = "me" ，s 开始于 indices[1] = 2 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 words[2] = "bell" ，s 开始于 indices[2] = 5 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"

思路：就是比如   s1 是 s2 的后缀  ，那么就  去掉s1
        1.自己写的，效率很低   hashset + 排序    将每一个单词的前缀放入集合
        2.看了题解     hashset              将是别人前缀的字符串从集合中删除
        3.字典树    实现方法 插入单词并且计算分数  效率高
 */
public class 最短的单词编码065 {
    public int minimumLengthEncoding3(String[] words) {
        int res = 0;

        Trie trie = new Trie(1);
        for (String word : words) {
            res += trie.insert(word);
        }
        return res;
    }

    class Trie {
        Trie[] child;
        boolean isEnd;
        int count;
        public Trie(int count) {
            child = new Trie[26];
            isEnd = false;
            this.count = count;
        }
        //插入并且计算分数.
        public int insert(String s) {
            int res = 0;
            Trie trie = this;
            boolean isNew = false;
            for (int i = s.length()-1; i >= 0; --i) {
                int index = s.charAt(i) - 'a';
                if (trie.child[index] == null) {
                    trie.child[index] = new Trie(trie.count+1);
                    isNew = true;
                }
                trie = trie.child[index];
                if (trie.isEnd && i != 0) {
                    //如果之前添加的trie是当前这个单词的后缀，就减掉分数，并删除该单词
                    trie.isEnd = false;
                    res -= trie.count;
                }
            }
            if (isNew) {//如果该单词不是之前的单词的后缀，就加上分数，并添加该单词
                trie.isEnd = true;
                res += trie.count;
            }
            return res;
        }
    }
    public int minimumLengthEncoding1(String[] words) {
        int res = 0;
        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
        Set<String> set = new HashSet<>();
        for (String word : words) {
            if (!set.contains(word)) {
                for (int i = 0; i < word.length(); i++) {
                    set.add(word.substring(i, word.length()));
                }
                //System.out.println(set);
                res += word.length()+1;
            }
        }
        return res;
    }
    public int minimumLengthEncoding2(String[] words) {
        int res = 0;
        //1.先把所有单词放到set
        Set<String> set = new HashSet<>(Arrays.asList(words));
        //2.如果有些单词是某个单词的后缀，就删掉
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }
        //3.计算长度
        for (String word : set) {
            res += word.length()+1;
        }
        return res;
    }
}
