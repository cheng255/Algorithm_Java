package day06;

import java.util.List;

/**
 * 在英语中，有一个叫做 词根(root) 的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典和一个句子，需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 需要输出替换之后的句子。
 * 示例 1：
 * <p>
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * 提示：
 * <p>
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写字母组成。
 * 1 <= sentence.length <= 10^6
 * sentence 仅由小写字母和空格组成。
 * sentence 中单词的总量在范围 [1, 1000] 内。
 * sentence 中每个单词的长度在范围 [1, 1000] 内。
 * sentence 中单词之间由一个空格隔开。
 * sentence 没有前导或尾随空格。
 * 思路：遇到这种前缀单词的就用前缀树解决
 */
public class 替换单词063 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }
        StringBuilder res = new StringBuilder();
        String[] splits = sentence.split(" ");
        for (String split : splits) {
            int i = trie.searchPrefix(split);
            if (i == 0) {
                res.append(split);
            } else {
                res.append(split.substring(0, i));
            }
            res.append(" ");
        }
        return res.toString().trim();
    }

    class Trie {
        Trie[] childs;
        boolean isEnd;

        public Trie() {
            childs = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (trie.childs[index] == null) {
                    trie.childs[index] = new Trie();
                }
                trie = trie.childs[index];
            }
            trie.isEnd = true;
        }

        public int searchPrefix(String word) {
            Trie trie = this;
            int i = 0;
            for (; i < word.length(); i++) {
                if (trie.isEnd) {
                    break;
                }
                int index = word.charAt(i) - 'a';
                if (trie.childs[index] == null) {
                    break;
                }
                trie = trie.childs[index];
            }
            return trie.isEnd ? i : 0;
        }
    }
}
