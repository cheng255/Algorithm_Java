package day01;

import java.util.HashMap;

/**
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0 开始计数 ，所以答案数组应当满足 0 <= answer[0] < answer[1] < numbers.length 。
 *
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：numbers = [1,2,4,6,10], target = 8
 * 输出：[1,3]
 * 解释：2 与 6 之和等于目标数 8 。因此 index1 = 1, index2 = 3 。
 * 示例 2：
 *
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[0,2]
 * 示例 3：
 *
 * 输入：numbers = [-1,0], target = -1
 * 输出：[0,1]
 * @author nuonuo
 * @create 2021-10-31 21:00
 *
 * 题目相对简单，   两种方法：      1: hashmap保存target-num[i]
 *                                  2. 双指针法
 *
 *                  双指针法相对更好，解决  三数之和，四数之和也可以
 */
public class 排序数组中两个数字之和006 {
    public int[] twoSum1(int[] numbers, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                res[0] = map.get(numbers[i]);
                res[1] = i;
                return res;
            } else {
                map.put(target - numbers[i], i);
            }
        }
        return res;
    }
    public int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        int l = 0, r = numbers.length-1;
        int sum = 0;
        while (l < r) {
            sum = numbers[l] + numbers[r];
            if (sum > target) {
                --r;
            } else if (sum < target) {
                ++l;
            } else {
                res[0] = l;
                res[1] = r;
                break;
            }
        }
        return res;
    }
}
