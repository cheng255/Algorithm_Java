package day07;

import java.util.Arrays;

/**
 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

 示例 1：

 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 输出：[[1,6],[8,10],[15,18]]
 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 示例 2：

 输入：intervals = [[1,4],[4,5]]
 输出：[[1,5]]
 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 提示：
 1 <= intervals.length <= 104
 intervals[i].length == 2
 0 <= starti <= endi <= 104


 思路：先把左边界排序，然后选择他合适的右边界   做题时间大概10分钟
  
 */
public class 合并区间074 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int[][] res = new int[intervals.length][2];
        int index = 0;//结果数组的下标
        int i = 0;
        while (i < intervals.length) {
            res[index][0] = intervals[i][0];//左边界
            res[index][1] = intervals[i][1];//右边界暂定
            i++;
            while (i < intervals.length && intervals[i][0] <= res[index][1]) {
                //有重叠
                res[index][1] = Math.max(res[index][1], intervals[i][1]);
                ++i;
            }
            index++;
        }
        return Arrays.copyOf(res, index);
    }
}
