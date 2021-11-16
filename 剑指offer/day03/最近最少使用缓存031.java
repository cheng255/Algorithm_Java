package day03;

import java.util.HashMap;

/**
 运用所掌握的数据结构，设计和实现一个  LRU (Least Recently Used，最近最少使用) 缓存机制 。

 实现 LRUCache 类：

 LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 示例：

 输入
 ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 输出
 [null, null, null, 1, null, -1, null, -1, 3, 4]

 解释
 LRUCache lRUCache = new LRUCache(2);
 lRUCache.put(1, 1); // 缓存是 {1=1}
 lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 lRUCache.get(1);    // 返回 1
 lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 lRUCache.get(2);    // 返回 -1 (未找到)
 lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 lRUCache.get(1);    // 返回 -1 (未找到)
 lRUCache.get(3);    // 返回 3
 lRUCache.get(4);    // 返回 4



 思路：也就是  LInkedHashMap     用  自己实现的链表 + hashmap实现
            不难  但写代码要细心
 */
public class 最近最少使用缓存031 {
    private class Node {
        int key;
        int val;
        Node next;
        Node pre;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Node head = null;
    Node tail = null;
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;
    int size;
    public 最近最少使用缓存031(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node cur = map.get(key);
        //将cur移动到头部
        moveToHead(cur);
        return cur.val;
    }

    public void put(int key, int value) {
        Node cur = map.get(key);
        if (cur != null) {
            cur.val = value;
            //将cur移动到头部
            moveToHead(cur);
        } else {
            cur = new Node(key, value);
            //在头部新加一个cur
            addHead(cur);

            map.put(key, cur);
            if (size > capacity) {//多了，就删除最后那个

                Node tailNode = removeTail();
                map.remove(tailNode.key);
            }
        }
    }
    public void moveToHead(Node cur) {
        removeNode(cur);
        addHead(cur);
    }
    public void addHead(Node cur) {
        cur.next = head.next;
        head.next.pre = cur;
        cur.pre = head;
        head.next = cur;
        size++;
    }
    public Node removeTail() {
        Node temp = tail.pre;//这块写的时候没有提前保存 所以出现bug
        removeNode(temp);
        return temp;
    }
    public void removeNode(Node cur) {
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        size--;
    }
}
