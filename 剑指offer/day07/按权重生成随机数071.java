package day07;

/**
 给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 i 的概率与 w[i] 成正比。

 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。

 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。
 示例 1：

 输入：
 inputs = ["Solution","pickIndex"]
 inputs = [[[1]],[]]
 输出：
 [null,0]
 解释：
 Solution solution = new Solution([1]);
 solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。

思路： 首先肯定是  总份数  total是 所有权重之和，  然后每个下标对应一个范围
            而这个范围可以用前缀和表示 { preSum[i-1]+1, preSum[i]}
            然后就是生成一个随机数，然后去在前缀和数组里找，满足的下标
            找的方式可以是二分。

        学到的点：  当二分里  有  类似   r = m 没有动时表示暂时符合，但不一定唯一。
                        这时候上面的  判断条件一般没有等于号。
    注意观察while（）！！！！   而且这种  r = m只能出现在r 不能是l
 */
public class 按权重生成随机数071 {
    int[] pre;//前缀和
    int total;
    public 按权重生成随机数071(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            pre[i] = pre[i-1] + w[i];
        }
        // total = Arrays.stream(w).sum();
        total = pre[w.length-1];
    }

    public int pickIndex() {
        int n = (int)(Math.random() * total) + 1;
        return search(n);
    }
    public int search(int n) {
        int l = 0, r = pre.length-1, m = 0;
        while (l < r) {
            m = (l + r) / 2;
            if (n > pre[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
//        while (l <= r) {
//            m = (l + r) / 2;
//            if (n > pre[m]) {
//                l = m + 1;
//            } else {
//                r = m - 1;
//            }
//        }
        return l;
    }
}
