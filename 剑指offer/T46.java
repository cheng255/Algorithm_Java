package exer06;

import java.util.LinkedList;

/**
 * 牛客网 剑指offer46题： 孩子们的游戏(圆圈中最后剩下的数)
 *
 * 题目描述：
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,
 * 继续0...m-1报数....这样下去....直到剩下最后一个小朋友,请找到这个小朋友(注：小朋友的编号是从0到n-1)
 *
 * 如果没有小朋友，请返回-1
 * @author nuonuo
 * @create 2020-08-05 11:54
 */
public class T46 {
}
/*
1.因为涉及到多次删除，所以使用链表来模拟环
 */
class Solution3 {
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        int i = 0;
        for (; i < n; i++) {
            list.add(i);
        }
        while (n > 1) {
            i =  (i + m - 1) % n; //记录要删除的人下标
            list.remove(i);
            n--;
        }
        return list.getFirst();
    }
}

/*
2.第一次要删除的人是m % n
 */
//class Solution4 {
//    public int LastRemaining_Solution(int n, int m) {
//
//    }
//}