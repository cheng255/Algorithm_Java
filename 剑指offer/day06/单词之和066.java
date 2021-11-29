package day06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 实现一个 MapSum 类，支持两个方法，insert 和 sum：

 MapSum() 初始化 MapSum 对象
 void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
  

 示例：

 输入：
 inputs = ["MapSum", "insert", "sum", "insert", "sum"]
 inputs = [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 输出：
 [null, null, 3, null, 5]

 解释：
 MapSum mapSum = new MapSum();
 mapSum.insert("apple", 3);
 mapSum.sum("ap");           // return 3 (apple = 3)
 mapSum.insert("app", 2);
 mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)

 提示：

 1 <= key.length, prefix.length <= 50
 key 和 prefix 仅由小写英文字母组成
 1 <= val <= 1000
 最多调用 50 次 insert 和 sum


 思路：hashMap  +  字典树
            难度还行，但做起来很难受，可能是代码量比较多的原因
 */
public class 单词之和066 {
    class Trie {
        Trie[] child;
        boolean isEnd;

        public Trie() {
            child = new Trie[26];
            isEnd = false;
        }
        //插入并返回
        public Trie get(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (trie.child[index] == null) {
                    trie.child[index] = new Trie();
                }
                trie = trie.child[index];
            }
            trie.isEnd = true;
            return trie;
        }
    }
    HashMap<Trie, Integer> map;
    Trie head;
    /** Initialize your data structure here. */
    public 单词之和066() {
        map = new HashMap<>();
        head = new Trie();
    }

    public void insert(String key, int val) {
        Trie trie = head.get(key);
        map.put(trie, val);
    }
    public void find(Trie t, List<Trie> list) {
        if (t == null) {
            return;
        }
        if (t.isEnd) {
            list.add(t);
        }
        for (int i = 0; i < t.child.length; i++) {
            find(t.child[i], list);
        }
    }

    public int sum(String prefix) {
        int res = 0;
        //1.拿到前缀结点
        Trie trie = head.get(prefix);
        if (!map.containsKey(trie)) {
            //前缀本身不是单词就得标记成false
            trie.isEnd = false;
        }
        //2.找这个节点的所有子孙结点
        List<Trie> list = new ArrayList<>();
        find(trie, list);
        //3.计算value
        for (Trie t : list) {
            res += map.get(t);
        }
        return res;
    }
}
