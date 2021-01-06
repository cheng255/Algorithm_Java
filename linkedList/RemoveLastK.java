package com.cheng.linkedList;

/**
 * 在单链表和双链表中删除倒数第k个结点
 * @author nuonuo
 * @create 2021-01-04 13:31
 */
public class RemoveLastK {
    private class SingleNode {
        SingleNode next;
        int val;
    }
    private class DoubleNode {
        DoubleNode pre;
        DoubleNode next;
        int val;
    }

    /**
     * 单链表删除倒数第k个结点思路：
     * 1.定义两个指针 l r    r 先走k步
     * 2.然后两个指针一起走，当r走到null时，l就是倒数第k个结点
     * 3.因为是单链表。所以走到要删除的结点的前一个节点就行了\
     *
     * 双链接也类似，只是删除结点方式不同而已
     * @param node
     * @param k
     */
    private static SingleNode removeLastK(SingleNode node, int k) {

        SingleNode lNode = node, rNode = node;
        for (int i = 0; i < k; i++) {
            if (rNode == null) { //不存在倒数第k个结点
                throw new RuntimeException("不存在倒数第k个结点");
            }
            rNode = rNode.next;
        }
        if (rNode == null) {
            //rNode 现在为null表示要删除的是第一个结点
            return node.next;
        }
        while (rNode.next != null) {
            rNode = rNode.next;
            lNode = lNode.next;
        }
        //此时lNode 为要删除的结点的前一个节点
        lNode.next = lNode.next.next;
        return node;
    }

}
