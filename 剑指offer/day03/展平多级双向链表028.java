package day03;

import java.util.Stack;

/**
 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 给定位于列表第一级的头节点，请扁平化列表，即将这样的多级双向链表展平成普通的双向链表，使所有结点出现在单级双链表中。
 示例 1：

 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 输出：[1,2,3,7,8,11,12,9,10,4,5,6]

        思路： 就是dfs   使用1.递归或者2.栈
                思路清晰的话还是很简单的。别乱！

        主要的思路是要去dfs的时候，要保存next结点  ！！！  无论是递归还是栈  都是这个原理
 */
public class 展平多级双向链表028 {
    private class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node dfs(Node head) {
        Node last = null;
        while (head != null) {
            Node nex = head.next;
            if (head.child != null) {
                Node childLast = dfs(head.child);//1、有孩子先处理孩子
                if (head.next != null) {//2.将孩子的尾部和next连起来
                    childLast.next = head.next;
                    head.next.prev = childLast;
                }
                //3.将当前结点和child连起来
                head.next = head.child;
                head.child.prev = head;
                head.child = null;

                last = childLast;
            } else {
                last = head;
            }
            head = nex;
        }
        return last;
    }
    public Node flatten2(Node head) {
        dfs(head);
        return head;
    }
    public Node flatten1(Node head) {
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        while (cur != null) {
            if (cur.child == null) {//1.没孩子
                if (cur.next == null) {
                    //1.1走到最后了就从栈中拿
                    Node top = null;
                    if (!stack.isEmpty()) {
                        top = stack.pop();
                    }
                    if (top != null) {

                        cur.next = top;
                        top.prev = cur;
                    }
                    cur = top;
                } else {//1.2没走到最后就继续走
                    cur = cur.next;
                }
            } else {//2.有孩子
                //2.1走到最后了
                //2.2还没走到最后，将下个添加到栈
                if (cur.next != null) {
                    stack.push(cur.next);
                }
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                cur = cur.next;
            }
        }
        return head;
    }
}
