package com.cheng.linkedList;

import java.util.HashMap;

/**
 * 复制含有随机结点的链表
 * <p>
 * 思路：便利两遍，
 * 第一遍把next域全部复制，并用HashMap将原链表和复制链表的每一个结点都产生映射关系
 * node 做键    copyNode 做值
 * 第二遍遍历   map.get(node).random = map.get(node.random);
 *
 * @author nuonuo
 * @create 2021-02-18 13:16
 */
public class CopyLinkedList {
    public static void main(String[] args) {
    }

    private static Node copyLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        Node copyHead = new Node(head.val);
        Node cur1 = head.next, cur2 = copyHead;
        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, copyHead);
        //1.第一遍
        while (cur1 != null) {
            cur2.next = new Node(cur1.val);//复制结点
            map.put(cur1, cur2.next);//加入map
            //循环
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        //2.第二遍
        cur1 = head;
        while (cur1 != null) {
            map.get(cur1).random = map.get(cur1.random);
            cur1 = cur1.next;
        }
        return copyHead;
    }

    private static class Node {
        Node next;
        Node random;
        int val;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + " " + next;
        }
    }
}
