package day02;

/**
 给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

 示例 1：

 输入：s = "abc"
 输出：3
 解释：三个回文子串: "a", "b", "c"
 示例 2：

 输入：s = "aaa"
 输出：6
 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"

 提示：

 1 <= s.length <= 1000
 s 由小写英文字母组成

 思路：  我的想法：1.中心扩展
 2，马拉车算法        每次都有写错的点，比较难   不过这次找到原因了   第54行！！！！
        马拉车算法要点    1.参数：   r数组：每个节点的最大扩展半径      maxR ：  最大右边界    c：中心节点
                        2.将字符串用#隔开
 */
public class 回文子字符串的个数020 {
    public int countSubstrings2(String s) {
        int res = 0;
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }
        int[] r = new int[sb.length()];
        int maxR = 0;
        int c = 0;
        int left = 0, right = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (i >= maxR) {//边界之外暴力搜
                left = i-1; right = i+1;
                while (left >= 0 && right < sb.length() && sb.charAt(left) == sb.charAt(right)) {
                    --left; ++right;
                }
                r[i] = right-i;
                if (right - 1 > maxR) {
                    maxR = right-1;
                    c = i;
                }
            } else {
                int i1 = c - (i - c);//i关于c的对称点
                if (i1 - r[i1] > c - r[c]) {//对称点包裹在边界内
                    r[i] = r[i1];
                } else {
                    left = i - (maxR - i) - 1;//这个第一次写错了！！！！！！！
                    right = maxR+1;
                    while (left >= 0 && right < sb.length() && sb.charAt(left) == sb.charAt(right)) {
                        --left; ++right;
                    }
                    r[i] = right-i;
                    if (right - 1 > maxR) {
                        maxR = right-1;
                        c = i;
                    }


                }
            }
            res += r[i]/2;

        }
        //System.out.println(Arrays.toString(r));
        return res;
    }

    public int countSubstrings1(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            //每一个位置都中心扩展
            res += func(s, i, i);
            res += func(s, i, i+1);
        }
        return res;
    }
    public int func(String s, int left, int right) {
        int res = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            res++;left--;right++;
        }
        return res;
    }
}
