package day04;

import java.util.Deque;
import java.util.LinkedList;

/**
 给定一个整数数组 asteroids，表示在同一行的小行星。
 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
 找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 示例 1：

 输入：asteroids = [5,10,-5]
 输出：[5,10]
 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。

    思路：挺简单的     但因为我事先知道了  所以下次再做做看！

            有学到   list变数组    后来改程序不用list也行
 */
public class 小行星碰撞037 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.addLast(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peekLast() > 0 && stack.peekLast() < -asteroid) {
                    stack.pollLast();
                }
                if (stack.isEmpty() || stack.peekLast() < 0) {
                    stack.addLast(asteroid);
                } else if (stack.peekLast() == -asteroid){
                    stack.pollLast();
                }
            }
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pollFirst();
        }
        return res;
    }
}
