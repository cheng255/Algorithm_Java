package exer05;

import java.util.Stack;

/**
 * 剑指offer37 ：两个链表的第一个公共结点
 * <p>
 * 分析：用两个栈实现两个链表从后往前比较，比较到下一个结点不相等的时候，当前结点就是第一个公共结点
 *
 * @author nuonuo
 * @create 2020-07-30 13:00
 */

public class T37 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (pHead1 != null || pHead2 != null) {
            if (pHead1 != null) {
                stack1.push(pHead1);
                pHead1 = pHead1.next;
            }
            if (pHead2 != null) {
                stack2.push(pHead2);
                pHead2 = pHead2.next;
            }
        }
        //判断是否有公共节点
        ListNode res = null;
        while (!stack1.empty() && !stack2.empty()) {
            ListNode node1 = stack1.pop();
            ListNode node2 = stack2.pop();
            if (node1 != node2) { //如果不相等就不用再比较了
                break;
            }
            //如果相同,记录下来
            res = node1;
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
