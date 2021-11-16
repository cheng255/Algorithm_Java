package day03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构：

 insert(val)：当元素 val 不存在时返回 true ，并向集合中插入该项，否则返回 false 。
 remove(val)：当元素 val 存在时返回 true ，并从集合中移除该项，否则返回 false 。
 getRandom：随机返回现有集合中的一项。每个元素应该有 相同的概率 被返回。
  

 示例 :

 输入: inputs = ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 [[], [1], [2], [2], [], [1], [2], []]
 输出: [null, true, false, true, 2, true, false, 2]
 解释:
 RandomizedSet randomSet = new RandomizedSet();  // 初始化一个空的集合
 randomSet.insert(1); // 向集合中插入 1 ， 返回 true 表示 1 被成功地插入

 randomSet.remove(2); // 返回 false，表示集合中不存在 2

 randomSet.insert(2); // 向集合中插入 2 返回 true ，集合现在包含 [1,2]

 randomSet.getRandom(); // getRandom 应随机返回 1 或 2

 randomSet.remove(1); // 从集合中移除 1 返回 true 。集合现在包含 [2]

 randomSet.insert(2); // 2 已在集合中，所以返回 false

 randomSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2

 思路：     insert和remove用 hash表实现       hashmap<val, index>
            random 用 数组实现
            数组的删除是O(n)  所以得用换位的方式将删除的数换到后面，然后删除
 */
public class 插入删除和随机访问都是O1的容器030 {
    HashMap<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random random = new Random();
    /** Initialize your data structure here. */
    public 插入删除和随机访问都是O1的容器030() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());//值 - 下标
        list.add(list.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int i = map.get(val);//要删除的结点下标
        map.put(list.get(list.size()-1), i);//将结尾的元素和当前元素换位
        list.set(i, list.get(list.size()-1));
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
