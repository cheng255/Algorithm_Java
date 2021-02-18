package com.cheng.linkedList;

/**
 *
 * 将单向链表按某值划分为左边小，中间相等，右边大的形式
 *          时：O(N)   空：O(N)
 * 思路：把数字放到数字，操作好再连成链表
 *
 * 进阶：保持稳定性
 *          时：O(N)   空：O(1)
 *  思路  创建三个结点，表示小于  大于 等于的头节点   遍历完也分好类  然后三个小链表连接起来
 *
 * @author nuonuo
 * @create 2021-02-18 11:57
 */
public class Partition {

    public static void main(String[] args) {
        Node node = new Node(4);
        node.next = new Node(2);
        node.next.next = new Node(1);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        System.out.println(partition(node, 4));
    }
    private static Node partition(Node head, int n) {
        if (head == null) {
            return null;
        }
        //三部分链表的头和尾
        Node sHead = null, mHead = null, bHead = null;
        Node sLast = null, mLast = null, bLast = null;
        Node cur = head;
        while (cur != null) {
            if (cur.val < n) { //小于
                if (sHead == null) {
                    sHead = cur;
                } else {
                    sLast.next = cur;
                }
                sLast = cur;
            } else if (cur.val > n) { //大于
                if (bHead == null) {
                    bHead = cur;
                } else {
                    bLast.next = cur;
                }
                bLast = cur;
            } else { //等于
                if (mHead == null) {
                    mHead = cur;
                } else {
                    mLast.next = cur;
                }
                mLast = cur;
            }
            cur = cur.next;
        }
        //然后连接三个链表

        //先连接小 中
        if (sLast != null) {
            sLast.next = mHead;
        }
        //再连接 中 大
        if (mLast != null) {
            mLast.next = bHead;
        }
        return sHead != null ? sHead : mHead != null ? mHead : bHead;
    }

    private static class Node {
        Node next;
        int val;

        @Override
        public String toString() {
            return val + " " + next;
        }

        public Node(int val) {
            this.val = val;
        }
    }
}
