package day06;

/**
 给定一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 示例 1：

 输入：nums = [3,10,5,25,2,8]
 输出：28
 解释：最大运算结果是 5 XOR 25 = 28.

    思路： 字典树 + 贪心
            就是把32位的整数 用树形存储，然后贪心去选择   OR  的结果

            字典树题目完了，   感觉写了很难受，每一题都很长很痛苦，
 */
public class 最大的异或067 {
    class Trie {
        Trie left;
        Trie right;
        //int sum;//这个数的个数
        public Trie() {
        }
        public void insert(int num) {
            Trie trie = this;
            for (int i = 31; i >= 0; --i) {
                int state = (num >> i) & 1;
                if (state == 0) {
                    if (trie.left == null) {
                        trie.left = new Trie();
                    }
                    trie = trie.left;
                } else {
                    if (trie.right == null) {
                        trie.right = new Trie();
                    }
                    trie = trie.right;
                }
            }
            //trie.sum++;
        }
    }
    public int findMaximumXOR(int[] nums) {
        //1.建立字典树
        Trie head = new Trie();
        for (int num : nums) {
            head.insert(num);
        }
        //2.从高位开始贪心选择出最大的运算结果

        Trie l = head, r = head;
        int res = func(l, r, 31);
        return res;
    }
    public int func(Trie l, Trie r, int i) {
        if (i < 0) {
            //结果的32位都选择完毕
            return 0;
        }
        //3.如果可以选择1   两种情况（既两个不同的）
        int res = 0;
        if (l.left != null && r.right != null) {
            res = (1 << i) | func(l.left, r.right, i-1);
        }
        if (l.right != null && r.left != null) {
            res = Math.max(res, (1 << i) | func(l.right, r.left, i-1));
        }
        if (res != 0) {
            return res;
        }
        //4.只能选择0
        if (l.left != null && r.left != null) {
            res = func(l.left, r.left, i-1);
        }
        if (l.right != null && r.right != null) {
            res = Math.max(res, func(l.right, r.right, i-1));
        }
        return res;
    }
}
