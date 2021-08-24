package com.cheng.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nuonuo
 * @create 2021-08-24 11:04
 * 有 n 个花园，按从 1 到 n 标记。另有数组 paths ，其中 paths[i] = [xi, yi] 描述了花园 xi 到花园 yi 的双向路径。在每个花园中，你打算种下四种花之一。
 *
 * 另外，所有花园 最多 有 3 条路径可以进入或离开.
 *
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 *
 * 以数组形式返回 任一 可行的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1、2、3、4 表示。保证存在答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 * 解释：
 * 花园 1 和 2 花的种类不同。
 * 花园 2 和 3 花的种类不同。
 * 花园 3 和 1 花的种类不同。
 * 因此，[1,2,3] 是一个满足题意的答案。其他满足题意的答案有 [1,2,4]、[1,4,2] 和 [3,2,1]
 * 示例 2：
 *
 * 输入：n = 4, paths = [[1,2],[3,4]]
 * 输出：[1,2,1,2]
 * 示例 3：
 *
 * 输入：n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * 输出：[1,2,3,4]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 104
 * 0 <= paths.length <= 2 * 104
 * paths[i].length == 2
 * 1 <= xi, yi <= n
 * xi != yi
 * 每个花园 最多 有 3 条路径可以进入或离开
 *
 */
public class 不邻接植花 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> gruee = new ArrayList<>();//邻接表
        for (int i = 0; i < n; i++) {
            gruee.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < paths.length; i++) {
            gruee.get(paths[i][0]-1).add(paths[i][1]-1);
            gruee.get(paths[i][1]-1).add(paths[i][0]-1);
        }
        boolean[][] flag = new boolean[n+1][5];//flag[i][j]表示第i个花园已经种了第j种花
        int[] res = new int[n];//结果集
        dfs(n, 1, gruee, res, flag);
        return res;
    }
    public boolean dfs(int n, int k, List<List<Integer>> gruee, int[] res, boolean[][] flag) {
        if (k > n) {
            return true;
        }
        for (int i = 1; i <= 4; i++) {
            if (flag[k][i]) {
                continue;
            }
            //到这表示第k个花园可以选择第i种花，现在要把他的相邻的花园和这种花的关联全部删除
            for (int j = 0; j < gruee.get(k-1).size(); j++) {
                flag[gruee.get(k-1).get(j) + 1][i] = true;
            }
            res[k-1] = i;
            if (dfs(n, k+1, gruee, res, flag)) {
                return true;
            }
            //回溯
            for (int j = 0; j < gruee.get(k-1).size(); j++) {
                flag[gruee.get(k-1).get(j) + 1][i] = false;
            }
        }
        return false;
    }
}
