package com.cheng.面试金典;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nuonuo
 * @create 2021-08-15 15:00
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 *
 * 注意：本题相对原题做了扩展
 *
 * 示例:
 *
 *  输入：4
 *  输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 *  解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 *
 */
public class 八皇后 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        queue8(list, sb, 0, n, 0, 0, 0);
        return res;
    }
    public void queue8(List<String> list, StringBuilder sb, int i, int n, int a, int b, int c) {
        if (i == n) {

            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (
                    (b >> j & 1) == 1 ||
                            (a >> j & 1) == 1 ||
                            (c >> j & 1) == 1)
                continue;

            //将左右斜线和竖直方向上下一次不能放的位置传参
            // b |= 1 << j;
            // a = (a >> 1 | 1 << j >> 1);
            // c = (c << 1 | 1 << j+1);

            sb.setCharAt(j, 'Q');
            list.add(sb.toString());
            sb.setCharAt(j, '.');
            queue8(list, sb, i+1, n, (a >> 1 | 1 << j >> 1), b | 1 << j, (c << 1 | 1 << j+1));
            list.remove(list.size()-1);

        }
    }
}
