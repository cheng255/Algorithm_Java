package com.cheng.linkedList;

/**
 * 将单链表的每k个节点之间逆序        现在的办法变量过多   有空看书修改
 * <p>
 * ，每k个节点之间逆序，之后不满k个的一组不做调整
 *
 * @author nuonuo
 * @create 2021-02-20 14:49
 */
public class ReverseEveryKNodes {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        System.out.println(reverseEveryKNodes(node, 3));
    }

    private static Node reverseEveryKNodes(Node head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        int i = 0;//记录从1到k
        //用做逆序的变量
        Node cur = head;
        Node pre = null;
        Node last = null;//代表上一组的逆序后的末尾
        Node now = head;//代表这一组的逆序后的末尾
        Node nex = null;
        Node start = null;
        Node temp = head;
        Node tempNex;
        while (temp != null) {
            tempNex = temp.next;
            i++;
            if (i == 1) {//每一组的开始 就是逆序后的末尾
                now = temp;
            }
            if (i == k) {//这一组循环完了
                while (cur != null && pre != temp) {//将这一组逆序
                    nex = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = nex;
                }
                //和上一组连接
                if (last != null) {
                    last.next = pre;
                }
                if (start == null) { //新的链表头
                    start = pre;
                }
                //更新遍历为下一组需要的值
                last = now;
                pre = null;
                i = 0;
            }
            temp = tempNex;
        }
        if (i != 0) {
            //表示最后一组不够k个
            last.next = nex;
        }
        return start;
    }


    private static class Node {
        Node next;
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
