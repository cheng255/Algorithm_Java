package day01;

/**
 * @author nuonuo
 * @create 2021-10-30 14:32
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "10"
 * 输出: "101"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 *
 *
 * 不难，   做题时间15分钟       做的太难了可以更快的！！    要注意写代码要美观，很多时间在重构
 */
public class 二进制加法002 {
    public String addBinary(String a, String b) {
        if (a.equals("0")) {
            return b;
        }
        if (b.equals("0")) {
            return a;
        }
        StringBuilder sb = new StringBuilder();
        int aIndex = a.length()-1;
        int bIndex = b.length()-1;
        int r = 0;int sum = 0;
        while (aIndex >= 0 || bIndex >= 0) {
            sum = r;
            if (aIndex >= 0) sum += (a.charAt(aIndex) - '0');
            if (bIndex >= 0) sum += (b.charAt(bIndex) - '0');
            if (sum == 1) {
                sb.append("1");
                r = 0;
            } else if (sum == 2) {
                r = 1;
                sb.append("0");
            } else if (sum == 3) {
                // r = 1;
                sb.append("1");
            } else {
                sb.append("0");
                r = 0;
            }
            if (aIndex >= 0) --aIndex;
            if (bIndex >= 0) --bIndex;
        }
        if (r == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
