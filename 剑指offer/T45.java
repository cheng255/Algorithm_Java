package exer06;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 牛客网剑指offer 45题： 扑克牌顺子
 * <p>
 * <p>
 * 题目描述
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,
 * 他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 *
 * @author nuonuo
 * @create 2020-08-05 10:42
 */
public class T45 {
    public static void main(String[] args) {
        System.out.println(new Solution2().isContinuous(new int[]{3, 0, 0, 0, 0}));
    }
}

/*
1.使用hashSet，顺子不能有重复元素 ，并且最大的和最小的差值小于4 ,注意大小王可以看成0
        所以分类讨论： 1。没有0的情况  2.有0的情况

        有0时，先去除0然后和1一样        时间复杂度：O(N)
                                        空间复杂度：O(N)
 */
class Solution1 {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 5) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        int max = 0, min = 14;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) { //有0时跳过
                continue;
            }
            if (set.contains(numbers[i])) {
                return false;
            }
            set.add(numbers[i]);
            max = (numbers[i] > max) ? numbers[i] : max;
            min = (numbers[i] < min) ? numbers[i] : min;
        }
        return max - min < 5;
    }
}

/*
2.排序加遍历    先将数组排序，此时相同的数一定相邻，只需判断部位0的数和与他相邻的数是否相等
                    时间复杂度：O(NlogN)
                    空间复杂度：O(1)  
 */
class Solution2 {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 5) {
            return false;
        }
        Arrays.sort(numbers);
        int minIndex = 0;//记录最小值的下标
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                minIndex++;
                continue;
            }
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
        }
        return numbers[numbers.length - 1] - numbers[minIndex] < 5;
    }
}
