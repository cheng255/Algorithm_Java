package com.cheng.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * LeetCode 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 *
 * 思路： 用一个线性表List 存入value
 *         一个HashMap map存value和list中所有存value的下标
 *
 *         插入时直接尾插到list
 *         删除val时找到map中存得val的所有下标，将最后一个下标和对应list中的元素删除
 * @author nuonuo
 * @create 2020-10-31 15:07
 */
public class O1Randomized {
    public static void main(String[] args) {
        RandomizedCollection r = new RandomizedCollection();
        System.out.println(r.insert(1));
        System.out.println(r.insert(1));
        System.out.println(r.insert(2));
    }


}
class RandomizedCollection {
    HashMap<Integer, List<Integer>> map;
    List<Integer> list;
    int size;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<Integer>();
        map = new HashMap<>();
        size = 0;
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        if (!map.containsKey(val)) {
            List<Integer> indexs = new ArrayList<>();
            indexs.add(size);
            map.put(val, indexs);
        } else {
            map.get(val).add(size);
        }
        size++;
        return true;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size() == 0) {
            return false;
        }
        int i = map.get(val).size() - 1;
        size--;

        list.remove(map.get(val).get(i));
        map.get(val).remove(i);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int index = (int)(Math.random() * (size - 1) + 1);
        return list.get(index);
    }
}
