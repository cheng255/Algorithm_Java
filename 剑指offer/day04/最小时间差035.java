package day04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 示例 1：

 输入：timePoints = ["23:59","00:00"]
 输出：1
 示例 2：

 输入：timePoints = ["00:00","23:59","00:00"]
 输出：0

    思路：1我的思路：变成分钟之后排序，然后找相邻的最小间隔
            2题解： 更好的方法：   O(N)       将分钟存到hash表    一共 0 - 1439分钟  直接找  不用排序
 */
public class 最小时间差035 {
    public int findMinDifference2(List<String> timePoints) {
        Set<Integer> timeInts = new HashSet<>();//1.记录时间
        for (String time : timePoints) {
            int sum = Integer.parseInt(time.substring(0,2)) * 60;
            sum += Integer.parseInt(time.substring(3,5));
            if (timeInts.contains(sum)) return 0;//如果有相同时间，直接返回间隔0
            timeInts.add(sum);
        }
        System.out.println(timeInts);
        //3.选出相邻两个中最小的   别忘了最后一个和第一个
        int res = Integer.MAX_VALUE;
        int pre = 0;
        //记录最大和最小时间
        int minTime = -1;
        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < 1440; i++) {
            if (timeInts.contains(i)) {
                if (pre > 0) {
                    res = Math.min(res, i - pre);
                }
                pre = i;
                if (minTime == -1) {
                    minTime = i;
                }
                maxTime = i;

            }
        }
        res = Math.min(res, 1440 - (maxTime - minTime));
        return res;
    }
    public int findMinDifference1(List<String> timePoints) {
        List<Integer> timeInts = new ArrayList<>();//1.记录时间
        for (String time : timePoints) {
            int sum = Integer.parseInt(time.substring(0,2)) * 60;
            sum += Integer.parseInt(time.substring(3,5));
            timeInts.add(sum);
        }
        timeInts.sort((o1, o2)-> o1-o2);//2.排序
        //System.out.println(timeInts);
        //3.选出相邻两个中最小的   别忘了最后一个和第一个
        int res = 1440 - (timeInts.get(timeInts.size()-1) - timeInts.get(0));
        for (int i = 1; i < timeInts.size(); i++) {
            res = Math.min(timeInts.get(i) - timeInts.get(i-1), res);
        }
        return res;
    }
}
