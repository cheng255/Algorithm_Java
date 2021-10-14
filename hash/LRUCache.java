package com.cheng.hash;

import java.util.HashMap;

/**
 * 面试题 16.25. LRU 缓存
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 *
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * @author nuonuo
 * @create 2021-10-14 12:53
 */
public class LRUCache {

    private HashMap<Integer, LinkedNode> cache;
    private int capacity;
    private int size;
    private LinkedNode head;
    private LinkedNode tail;


    public LRUCache(int capacity) {
        cache = new HashMap<>();
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
        this.size = 0;
    }

    public void addToHead(LinkedNode node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
        ++size;
    }

    public LinkedNode removeTail() {
        LinkedNode node = tail.pre;
        node.pre.next = tail;
        tail.pre = node.pre;
        --size;
        return node;
    }

    public void removeNode(LinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        --size;
    }

    public void moveNodeToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) {//缓存中没有
            return -1;
        }
        moveNodeToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node == null) {//缓存中之前没有
            LinkedNode newNode = new LinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            if (size > capacity) {
                LinkedNode tail = removeTail();
                cache.remove(tail.key);
            }
        } else {//之前就有
            node.val = value;
            moveNodeToHead(node);
        }


    }

    class LinkedNode {
        int val;
        int key;
        LinkedNode pre;
        LinkedNode next;

        public LinkedNode() {
        }

        public LinkedNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

}
