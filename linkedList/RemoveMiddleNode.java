package com.cheng.linkedList;

/**
 * 删除链表的中间结点和 a/b 处的结点
 *
 * @author nuonuo
 * @create 2021-01-04 13:55
 */
public class RemoveMiddleNode {
    /**
     * 删除链表 a/b 处的结点思路： 计算 double r = (double) (n*a) / (double)b    (n是链表长度)
     * r 向上取整  第 r个结点就是要删除的结点
     */
    private static Node removeSpecialNode(Node node, int a, int b) {
        if (node == null || a > b) {
            return null;
        }
        int n = 0;
        Node cur = node;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        int r = (int)((double) (n * a) / b + 0.5);
        if (r == 1) {
            return node.next;
        }
        cur = node;
        Node pre = node;
        while (r > 1) {
            pre = cur;
            cur = cur.next;
            r--;
        }
        pre.next = cur.next;
        return node;
    }
    /**
     * 删除链表中间结点思路： 很容易，定义快指针 一次走两步   满指针一次走一步
     * 当快指针走到null时，慢指针的位置就是要删除的结点
     *
     * @param node
     * @return
     */
    private static Node removeMidNode(Node node) {
        if (node == null) {//没有结点
            return null;
        }
        Node pre = node, low = node, fast = node;
        while (true) {
            fast = fast.next;//1步
            if (fast == null) {
                break;
            }
            fast = fast.next;//2步
            if (fast == null) {
                //fast走到null 此时low就是要删除的结点
                break;
            }
            pre = low;
            low = low.next;
        }
        if (low.equals(node)) {
            //要删除的是头节点
            return node.next;
        }
        //要删除的是其他节点
        pre.next = low.next;
        return node;
    }

    private class Node {
        Node next;
        int val;
    }
}
