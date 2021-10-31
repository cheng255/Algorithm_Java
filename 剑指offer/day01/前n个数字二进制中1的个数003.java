package day01;

/**
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 *
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: n = 2
 * 输出: [0,1,1]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2:
 *
 * 输入: n = 5
 * 输出: [0,1,1,2,1,2]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *  
 * 说明 :
 * 0 <= n <= 105
 * 进阶:
 *
 * 给出时间复杂度为 O(n*sizeof(integer)) 的解答非常容易。但你可以在线性时间 O(n) 内用一趟扫描做到吗？
 * 要求算法的空间复杂度为 O(n) 。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount ）来执行此操作。
 *
 * @author nuonuo
 * @create 2021-10-30 19:27
 *
 * 1 2 4 8 16 这样的数都只有1个0     所以   比如 dp[15] = 8 + dp[7]   动态规划解题
 *
 * 解题用时：10分钟   比较简单    但需要每次都想得到。  多看看2进制规则
 *
 */
public class 前n个数字二进制中1的个数003 {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        if (n == 0) return res;
        int k = 1;
        while (k <= n) {
            for (int i = 0; i < k; i++) {
                if (k + i <= n) {
                    res[k+i] = 1 + res[i];
                }
            }
            k <<= 1;
        }
        return res;
    }
}
