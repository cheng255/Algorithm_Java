package exer05;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * 剑指0ffer41题：和为s的两个数字 VS 和为s的连续正数序列
 * @author nuonuo
 * @create 2020-08-01 21:58
 */
public class T41 {
}

/**
 * 和为s的两个数字
 */
//1.使用hashmap映射当前n和s-n
class Solution1 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new Solution1().FindContinuousSequence(new int[]{1, 2, 3, 4, 5}, 7);
        System.out.println(integers);
    }
    public ArrayList<Integer> FindContinuousSequence(int[] array, int s) {
        ArrayList<Integer> res = new ArrayList<>();
        //1.使用HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : array) {
            if (map.get(n) != null) {
                res.add(n);
                res.add(map.get(n));
                break;
            }
            map.put(s - n, n);
        }
        return res;
    }
}
//2.因为数组是升序的，所以可以用双指针，分别指向数组头尾，也是最小和最大的数
//    设为 l 和 r  如果 l+r < s 就移动l  反之亦然
class Solution2 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new Solution2().FindContinuousSequence1(new int[]{1, 2, 3, 4, 5}, 7);
        System.out.println(integers);
    }
    public ArrayList<Integer> FindContinuousSequence1(int[] array, int s) {
        ArrayList<Integer> res = new ArrayList<>();
        int l = 0, r = array.length - 1;
        while (l < r) {
            if (array[l] + array[r] < s) {
                l++;
            } else if (array[l] + array[r] > s) {
                r--;
            } else {
                res.add(array[l]);
                res.add(array[r]);
                break;
            }
        }
        return res;
    }
}
/**
 * 和为sum的连续正数序列
 * 分析，根据之前题的经验，我们只需要用两个指针初始指向1和2
 * 不同的是当小于时，移动r，大于时移动l，都是向后移动，然后用一个值记录和s
 * 当s == sum时， 同时移动两个指针
 */
class Solution {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = new Solution().FindContinuousSequence(15);
        System.out.println(lists);
    }
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        int l = 1, r = 2, s = 3;
        while (l < r && r < sum) {
            if (s < sum) { //小于sum时，继续往后加
                r++;
                s += r;
            } else if (s > sum) { //大于sum时，从前面开始减
                s -= l;
                l++;
            } else { //等于sum时，加入list,然后同时加和减
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = l; i <= r; i++) {
                    list.add(i);
                }
                res.add(list);
                s -= l;
                l++;
                r++;
                s += r;
            }
        }
        return res;
    }
}

