package com.cheng.linkedList;

/**
 * 环形单链表的约瑟夫问题
 * <p>
 * 原问题：
 * 输入：一个环形单向链表的头节点head 和报数的值m
 * 返回：最后生存下来的结点，且这个节点自己组成环形单向链表，其他节点都删掉
 * 进阶：
 * 如果链表节点数为N， 想在时间复杂度为O(N)完成原问题的要求，该怎么实现？
 *
 * @author nuonuo
 * @create 2021-01-10 13:16
 */
public class Josephus {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = node;
        System.out.println(josephus(node, 3).val);

    }

    /**
     * 进阶版本， 推出一个递归公式 old = (new + m + 1) % i + 1  old:Num(i)   new:Num(i-1)
     *                                                      Num(i):表示长度为i的环中约瑟夫为题的解
     *
     *            详情看程序员代码面试指南
     * @param node
     * @param num
     * @return
     */
    private static Node josephus1(Node node, int num) {
        //1.找到循环链表的长度
        int len = 1;
        Node cur = node;
        while (cur.next != node) {
            len++;
            cur = cur.next;
        }
        //2.直接递归
        int res = getJos(len, num);//第res个结点就是答案
        cur = node;
        while (--res != 0) {
            cur = cur.next;
        }
        //3.自成环
        cur.next = cur;
        return cur;
    }

    private static int getJos(int i, int m) {
        if (i == 1) {
            return 1;
        }
        return (getJos(i-1, m) + m + 1) % i + 1;
    }

    private static Node josephus(Node node, int num) {
        int t = 0;
        Node cur = node;
        Node per = null;
        while (!cur.equals(per)) {
            t++;
            if (t == num) {
                t = 0;
                cur = cur.next;
                per.next = cur;
            } else {
                per = cur;
                cur = cur.next;
            }
        }
        return cur;
    }

    private static class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

}
