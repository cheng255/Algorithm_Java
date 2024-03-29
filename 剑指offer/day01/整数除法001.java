package day01;

/**
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 *
 *  
 *
 * 注意：
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231−1]。本题中，如果除法结果溢出，则返回 231 − 1
 *  
 *
 * 示例 1：
 *
 * 输入：a = 15, b = 2
 * 输出：7
 * 解释：15/2 = truncate(7.5) = 7
 * 示例 2：
 *
 * 输入：a = 7, b = -3
 * 输出：-2
 * 解释：7/-3 = truncate(-2.33333..) = -2
 * 示例 3：
 *
 * 输入：a = 0, b = 1
 * 输出：0
 * 示例 4：
 *
 * 输入：a = 1, b = 1
 * 输出：1
 *  
 *
 * 提示:
 *
 * -231 <= a, b <= 231 - 1
 * b != 0
 * @author nuonuo
 * @create 2021-10-30 14:14
 *
 *
 * 没有想象中的简单， 做题时间大概30分钟    其实不难，以后要再复习！！！
 */
public class 整数除法001 {
    public int divide(int a, int b) {
        boolean isPos = a > 0 && b > 0 || a < 0 && b < 0;

        long aa = Math.abs((long)a);
        long bb = Math.abs((long)b);

        if (aa == bb) {
            return isPos ? 1 : -1;
        }
        if (bb == 1) {
            if (aa > Integer.MAX_VALUE) {
                return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            return isPos ? (int)aa : -(int)aa;
        }

        //乘法分配法    （a + b）* c  =  (a * c) + (b * c)

        long res = 0;
        long A = aa;
        long B = bb;
        while (A >= B) {
            int i = 0;
            while (A >= B) {
                i = i == 0 ? 1 : i + i;
                B <<= 1;
            }
            res += i;
            if (A == (B >> 1)) {
                break;
            }
            A = A - (B >> 1);
            B = bb;
        }
        if (res > Integer.MAX_VALUE) {
            return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return isPos ? (int)res : -(int)res;
    }
}
