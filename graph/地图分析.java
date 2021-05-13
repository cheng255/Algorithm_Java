package com.cheng.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 你现在手里有一份大小为 N x N 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的。
 * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - x1| + |y0 - y1| 。
 * 如果网格上只有陆地或者海洋，请返回 -1
 * @author nuonuo
 * @create 2021-05-13 19:31
 */
public class 地图分析 {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int maxDistance(int[][] grid) {
        //找到每一个海洋的最近陆地
        int res = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    res = Math.max(res, getLength(grid, i, j));
                }
            }
        }
        return res;
    }
    public int getLength(int[][] grid, int x, int y) {
        //广度优先遍历 , 队列中存放 x,y,距离
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        flag[x][y] = true;
        queue.offer(new int[]{x, y, 0});//和自己的距离为0
        int[] temp = null;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            for (int i = 0; i < dx.length; i++) {//将上下左右一格以内的加入队列
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
                    //越界了
                    continue;
                }
                if (!flag[nx][ny]) {//还没有访问过
                    flag[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, temp[2] + 1});
                    if (grid[nx][ny] == 1) {
                        return temp[2] + 1;//找到最近的陆地就返回
                    }
                }
            }
        }
        return -1;
    }
}
