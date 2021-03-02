package com.cheng.linkedList;

/**
 * 向有序的环形单链表中插入新节点
 * @author nuonuo
 * @create 2021-03-01 13:43
 */
public class InsertIntoOrderedCircularLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(3);
        node1.next.next = new Node(4);
        node1.next.next.next = new Node(4);
        node1.next.next.next.next = new Node(5);
        node1.next.next.next.next.next = node1;
        System.out.println(insert(node1, 3));
    }
    private static Node insert(Node head, int num) {
        Node newNode = new Node(num);
        if (head == null) {
            return newNode;
        }
        Node cur = head;
        Node pre = null;
        while (cur.next != cur && cur.next.val >= cur.val) {
            //表示没有到最后就继续
            if (num <= cur.val) {
                //插到cur前面
                if (pre == null) {//如果要插的位置是链表头 需要找到末尾tail tail.next = newNode  newNode.next = cur
                    Node tail = head;
                    while (tail.next != tail && tail.next.val >= tail.val) {
                        tail = tail.next;
                    }
                    tail.next = newNode;
                    newNode.next = cur;
                    return newNode;
                } else {
                    pre.next = newNode;
                    newNode.next = cur;
                    return head;
                }
            }
            pre = cur;
            cur = cur.next;
        }
        //到这表示链表只有一个元素
        newNode.next = head;
        head.next = newNode;
        return head.val < num ? head : newNode;
    }
    private static class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + " ";
        }
    }
}
