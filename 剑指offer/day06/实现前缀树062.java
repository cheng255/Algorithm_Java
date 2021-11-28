package day06;

/**
 Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

 请你实现 Trie 类：

 Trie() 初始化前缀树对象。
 void insert(String word) 向前缀树中插入字符串 word 。
 boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
  

 示例：

 输入
 inputs = ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 inputs = [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 输出
 [null, null, true, false, true, null, true]

 解释
 Trie trie = new Trie();
 trie.insert("apple");
 trie.search("apple");   // 返回 True
 trie.search("app");     // 返回 False
 trie.startsWith("app"); // 返回 True
 trie.insert("app");
 trie.search("app");     // 返回 True
 提示：

 1 <= word.length, prefix.length <= 2000
 word 和 prefix 仅由小写英文字母组成
 insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次

思路：  前缀树  第一次接触      class Trie {
                                    Trie[]
                                    boolean isEnd
                                }

 */
public class 实现前缀树062 {
    class Trie {

        Trie[] childs;
        boolean isEnd;//是否有该字符结尾的单词
        /** Initialize your data structure here. */
        public Trie() {
            childs = new Trie[26];
            isEnd = false;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                int index = (word.charAt(i) - 'a');
                if (trie.childs[index] == null) {
                    trie.childs[index] = new Trie();
                }
                trie = trie.childs[index];
            }
            trie.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie trie = find(word);
            return trie != null && trie.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie trie = find(prefix);
            return trie != null;
        }
        public Trie find(String s) {
            Trie trie = this;
            for (int i = 0; i < s.length(); i++) {
                int index = (s.charAt(i) - 'a');
                if (trie.childs[index] == null) {
                    return null;
                }
                trie = trie.childs[index];
            }
            return trie;
        }
    }
}
