package day03;

/**
 给定两个单链表的头节点 headA 和 headB ，请找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。

 题目数据 保证 整个链式结构中不存在环。
 注意，函数返回结果后，链表必须 保持其原始结构 。
 示例 1：
 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 输出：Intersected at '8'
 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 示例 2：



 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 输出：Intersected at '2'
 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 示例 3：



 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 输出：null
 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 这两个链表不相交，因此返回 null 。
  
 提示：

 listA 中节点数目为 m
 listB 中节点数目为 n
 0 <= m, n <= 3 * 104
 1 <= Node.val <= 105
 0 <= skipA <= m
 0 <= skipB <= n
 如果 listA 和 listB 没有交点，intersectVal 为 0
 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
  

 进阶：能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？


 思路：   1.我的思路：遍历找到长链表比短链表长多少。 然后再遍历一遍得出答案
        2.看完题解 发现思路一样，但代码太简单了!!!!   有疑问 看题解！！！

 */
public class 两个链表的第一个重合节点023 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = (curA == null) ? headB : curA.next;
            curB = (curB == null) ? headA : curB.next;
        }
        return curA;

    }
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int flag = 0;//1表示A长      2表示B长
        int num = 0;//长的数量
        while (curA.next != null || curB.next != null) {
            if (curA.next != null) {
                curA = curA.next;
                if (flag == 1) {
                    num++;
                }
            } else if (flag == 0){
                flag = 2;
                num = 0;
            }
            if (curB.next != null) {
                curB = curB.next;
                if (flag == 2) {
                    num++;
                }
            } else if (flag == 0){
                flag = 1;
                num = 1;
            }
        }
        if (curA != curB) {//不相交
            return null;
        }
        ListNode longNode = flag == 1 ? headA : headB;
        ListNode shortNode = longNode == headA ? headB : headA;
        while (longNode != shortNode) {
            longNode = longNode.next;
            if (num <= 0) {
                shortNode = shortNode.next;
            }
            num--;
        }
        return longNode;
    }
}
