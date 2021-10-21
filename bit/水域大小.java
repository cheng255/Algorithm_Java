package com.cheng.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
 * 若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
 * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * 示例：
 *
 * 输入：
 * [
 *   [0,2,1,0],
 *   [0,1,0,1],
 *   [1,1,0,1],
 *   [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * @author nuonuo
 * @create 2021-10-09 13:16
 */
public class 水域大小 {
    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    list.add(dfs(land, i, j));
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;

    }
    public int dfs(int[][] land, int i, int j) {
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] != 0) {
            return 0;
        }
        land[i][j] = 1;
        int res = 1;
        res += dfs(land, i-1, j);
        res += dfs(land, i-1, j+1);
        res += dfs(land, i-1, j-1);
        res += dfs(land, i, j+1);
        res += dfs(land, i, j-1);
        res += dfs(land, i+1, j-1);
        res += dfs(land, i+1, j);
        res += dfs(land, i+1, j+1);
        return res;
    }
}
