package day03;

/**
 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。

 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。

 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。

 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。

 示例 1：

 输入：head = [3,4,1], insertVal = 2
 输出：[3,4,1,2]
 解释：在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2 。新插入的节点应该在 1 和 3 之间，插入之后，整个列表如上图所示，最后返回节点 3 。


    思路： 这道题不难  但脑子容易乱      ！！！！   通过率也不高
                三种可能：  1.可以插在中间   2.比最小的还小  3.比最大的还大

                我在做的时候怕head的位置问题  但发现多虑了   直接循环条件    （cur.next != head）
 */
public class 排序的循环链表029 {
    private class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
    public Node insert1(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node cur = head;
        while (cur.next != head) {
            if (cur.next.val >= insertVal && cur.val <= insertVal) {
                break;
            }
            if (cur.next.val < cur.val) {
                if (cur.next.val >= insertVal) break;
                if (cur.val <= insertVal) break;
            }
            cur = cur.next;
        }
        cur.next = new Node(insertVal, cur.next);
        return head;
    }
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        if (head.next == head) {
            head.next = newNode;
            newNode.next = head;
            return head;
        }
        Node cur = head.next;
        Node pre = head;
        int flag = 0;
        while (flag < 2) {//选出最大的结点和最小的结点
            if (pre == head) {
                flag++;
            }
            if (pre.val > cur.val) {
                break;
            }
            pre = cur;  cur = cur.next;
        }
        if (flag >= 2 || pre.val <= newNode.val || cur.val >= newNode.val) {
            //说明全部一样 或者比最大的都大 或者比最小的都小
            newNode.next = cur;
            pre.next = newNode;
            return head;
        }
        //否则就肯定在中间某位置插入
        while (cur.val <= newNode.val) {
            pre = cur;
            cur = cur.next;
        }
        newNode.next = cur;
        pre.next = newNode;
        return head;
    }
}
