package day06;

/**
 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于已构建的神奇字典中。

 实现 MagicDictionary 类：

 MagicDictionary() 初始化对象
 void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
  

 示例：

 输入
 inputs = ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
 inputs = [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
 输出
 [null, null, false, true, false, false]

 解释
 MagicDictionary magicDictionary = new MagicDictionary();
 magicDictionary.buildDict(["hello", "leetcode"]);
 magicDictionary.search("hello"); // 返回 False
 magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
 magicDictionary.search("hell"); // 返回 False
 magicDictionary.search("leetcoded"); // 返回 False
 提示：

 1 <= dictionary.length <= 100
 1 <= dictionary[i].length <= 100
 dictionary[i] 仅由小写英文字母组成
 dictionary 中的所有字符串 互不相同
 1 <= searchWord.length <= 100
 searchWord 仅由小写英文字母组成
 buildDict 仅在 search 之前调用一次
 最多调用 100 次 search

 思路：字段树 + 递归  详情看代码        做是做出来了，但对于字典树还是不太熟练，写起来很难受很痛苦

 */
public class 神奇的字典064 {
    class MagicDictionary {

        MagicDictionary[] child;
        boolean isEnd;

        /** Initialize your data structure here. */
        public MagicDictionary() {
            child = new MagicDictionary[26];
            isEnd = false;
        }

        public void buildDict(String[] dictionary) {
            for (String word : dictionary) {
                MagicDictionary trie = this;
                for (int i = 0; i < word.length(); i++) {
                    int index = word.charAt(i) - 'a';
                    if (trie.child[index] == null) {
                        trie.child[index] = new MagicDictionary();
                    }
                    trie = trie.child[index];
                }
                trie.isEnd = true;
            }
        }

        public boolean search(String searchWord) {
            return helper(searchWord, 0, false, this);
        }
        public boolean helper(String searchWord, int i, boolean isChange, MagicDictionary trie) {
            if (trie == null) {
                return false;
            }
            if (i >= searchWord.length()) {
                return isChange && trie.isEnd;//单词走完了，这个单词是否达标有两点
                //1.换过一次字母， 2.词典中有该单词
            }
            int index = searchWord.charAt(i) - 'a';
            if (!isChange) {
                //1.之前没换过，可以换当前元素
                for (int j = 0; j < trie.child.length; j++) {
                    if (j != index && trie.child[j] != null) {
                        if (helper(searchWord, i+1, true, trie.child[j])) {
                            return true;
                        }
                    }
                }
            }
            //2.不换当前元素
            return helper(searchWord, i+1, isChange, trie.child[index]);
        }
    }
}
