package day07;

/**
 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。

 正数的平方根有两个，只输出其中的正数平方根。

 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。

  

 示例 1:

 输入: x = 4
 输出: 2
 示例 2:

 输入: x = 8
 输出: 2
 解释: 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
 提示:

 0 <= x <= 231 - 1

 一个数的平方根肯定不会大于这个数的一半，利用这个性质来做二分：

 设置左右边界：从1到这个数本身；
 若mid的平方小于x，且mid + 1的平方大于x，则mid就是x的平方根，根据这一点来终止二分查找。

 */
public class 求平方根072 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 4) {
            return 1;
        }
        int l = 1, r = x/2, m = 0;
        while (l <= r) {
            m = (r - l) / 2 + l;
            if (m > Integer.MAX_VALUE / m || m * m > x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r;

    }
}
