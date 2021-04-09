package com.cheng.dp.面试指南;

/** 题目：给定一个整数n，代表汉诺塔游戏中从小到大放置的n个圆盘，假设开始时所有的圆盘都在左边的柱子上
 * 按照汉诺塔游戏的要求把所有的圆盘都移动到右边的主子上，
 * 实现函数打印最优移动轨迹。
 *
 * 例：
 * n=1  打印：   move from left to right
 * n=2  打印：   move from left to mid
 *               move from left to right
 *               move from mid to right
 *
 *  进阶题目：给定一个整形数组arr，其中只含有1,2,3
 *  代表所有圆盘目前的状态，1代表左柱，2代表中柱，3代表右柱
 *  arr[i]的值代表第i+1个圆盘的位置。比如 arr=[3,3,2,1],
 *  代表第1个圆盘在右柱，第2个圆盘在右柱，第3个圆盘在中柱上，
 *  第4个圆盘在左柱上。 如果arr代表的状态是最优的移动轨迹中出现的状态，
 *  就返回是第几个状态；如果不是，就返回-1
 *
 *  例子：   arr[1,1] 返回0    arr[2,1] 返回1    arr[3,3] 返回3     arr[2,2] 返回-1
 *  要求：时间复杂度O(N)，额外空间复杂度O(1)
 * @author nuonuo
 * @create 2021-04-08 12:26
 */
public class 汉诺塔问题 {
    public static void main(String[] args) {
        hanoi(4, 'a','b','c');
        System.out.println(HanoiStatus(new int[]{3,3}));

    }

    /**
     * 进阶
     * 先思考汉诺塔过程
     *      1：如果n=1   就是 a->c
     *      2:如果n=2    就是先（将上面一个从a借助c移动到b），然后下面那个移动到c，然后再（将上面那个从b借助a移动到c）
     *                  也就是a->b   a->c  b->c 移动了3次
     *     3:如果n=3    就是先(将上面两个从a借助c移动到b)，然后下面那个移动到c，然后(上面那两个再从b借助a移动到c)
     *                  括号中的操作就是1中n=2的操作，只是参数变了而已。所以可以判断 n=3的时候需要移动7次
     *     4：如果n=4   同理就是执行了两边n=3操作，和a->c的操作，参数不同而已。也就是需要移动7+7+1 = 15次
     *     所以移动次数 = 2^n - 1
     *     如果把移动看成上面分析的三个阶段的话：
     *   arr[i]表示第i+1个圆盘的位置，
     *   如果最底下的那个圆盘在左柱，表示第一个阶段没完或者刚完，移动次数<2^(n-1)具体看上面n-1个圆盘的情况。
     *                     在中柱，表示错误，返回-1
     *                     在右柱，表示至少移动了2^(n-1)，然后再看上面n-1个圆盘的情况。
     *                     这就是递归的思路。
     */
    private static int HanoiStatus(int[] arr) {
        char from = 1;
        char to = 3;
        char mid = 2;
        int res = 0;
        char temp;
        int i = arr.length-1;
        while (i >= 0) {
            if (arr[i] == mid) {//最下边的在中柱
                return -1;
            }
            if (arr[i] == from) {//左柱,表示第二个阶段还没开始，也就是将n-1个圆盘从左柱移动到中柱还没完
                temp = to;
                to = mid;
            } else {//右柱，表示前两个阶段已经完了，最后一个阶段是将n-1个圆盘从中柱移动到右柱
//                res += Math.pow(2, k);
                res += 1 << i;
                temp = from;
                from = mid;
            }
            mid = temp;
            i--;
        }
        return res;
    }

    /**
     * 汉诺塔问题
     */
    private static void hanoi(int n, char a, char b, char c) {
        if (n == 1) {//如果只有一个，就直接从a->c
            print(a, c);
            return;
        }
        /*
        否则就先把上面的n-1个移动到b，然后再把最底层的1个移动到c，然后再把那n-1个从b移动到c
        这里搞清楚递归函数的含义是：将a上的n个圆盘借助b移动到c
         */
        hanoi(n-1, a, c, b);//将上面n-1个圆盘从a借助c移动到b
        print(a, c);//然后将最底下这个圆盘移动到c
        hanoi(n-1, b, a, c);//最后将那n-1个圆盘从b借助a移动到c
    }


//    /**
//     * 首先举个例子
//     * 1：如果n=1   就是 a->c
//     * 2:如果n=2    就是先（将上面一个从a借助c移动到b），然后下面那个移动到c，然后再（将上面那个从b借助a移动到c）
//     *              也就是a->b   a->c  b->c
//     * 3:如果n=3    就是先(将上面两个从a借助c移动到b)，然后下面那个移动到c，然后(上面那两个再从b借助a移动到c)
//     *              括号中的操作就是1中n=2的操作，只是参数变了而已。所以可以判断 n=3的时候需要移动7次
//     * 4：如果n=4   同理就是执行了两边n=3操作，和a->c的操作，参数不同而已。也就是需要移动7+7+1 = 15次
//     *
//     *  参数和什么有关呢，可以反推一下，   n=3时，是将上面两个从a借助c移动到b，这个操作本身和题中n=2相比，
//     *                              是把参数顺序  a b c 换成了  a c b;
//     *                                  n=4时，第一步是将上面三个从a借助c移动到b，这个操作首先是要
//     *                                  将上面上面两个从a借助b移动到c，和题中n=2相同。
//     *  所以可以总结出规律：n为偶数时，第一步为a->b   n为奇数时，第一步为a->c
//     *          第一步就好比是n=1完成了，而他作为n=2的第一部分。一直执行到n为止。
//     *
//     *
//     */
//    private static void hanoi非递归(int n, char a, char b, char c) {
//        int t = (int) (Math.pow(2, n) - 1);//移动次数
//        char[][] dp = new char[t][2];
//        //表示第一步
//        char from = a;//从哪来
//        char to = (n&1) == 1 ? c : b;//到哪去
//        char help = dp[0][1] == 'b' ? 'c' : 'b';//表示这一步的辅助结点，（没用到的那个）
//        print(from, to);
//        for (int i = 2; i <= n; i++) {
//
//        }
//    }

    private static void print(char a, char b) {
        System.out.format("%c->%c\n", a, b);
    }
}
