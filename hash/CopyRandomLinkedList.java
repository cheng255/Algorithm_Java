package com.cheng.hash;

import java.util.HashMap;

/**
 * LeetCode T138. 复制带随机指针的链表
 *给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的 深拷贝。 
 *
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *
*/
 class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyRandomLinkedList {
     //思路： 建立一个map对新老结点创建映射关系
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node myHead = new Node(head.val);
        Node cur1 = head.next; Node cur2 = myHead;
        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, myHead);
        //先走一遍，将next指针链表构建完成,并且将
        while (cur1 != null) {
            Node tem = new Node(cur1.val);
            cur2.next = tem;
            map.put(cur1, tem);
            cur1 = cur1.next;
            cur2 = cur2.next;

        }
        //然后再关联ranom
        cur2 = myHead; cur1 = head;
        while (cur2 != null) {
            Node curRandom = cur1.random;

            if (curRandom == null) {
                cur2.random = null;
            } else {
                cur2.random = map.get(curRandom);

            }

            cur2 = cur2.next;
            cur1 = cur1.next;
        }
        return myHead;
    }
}
