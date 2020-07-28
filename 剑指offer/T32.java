package exer05;

/**
 * 剑指offer32题：从1到n整数中1出现的次数
 * @author nuonuo
 * @create 2020-07-27 15:45
 */
public class T32 {
    private static int NumberOf1Between1AndN_Solution(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
