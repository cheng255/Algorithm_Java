package com.cheng.stackqueue;

/**
 * 程序员代码面试指南 用栈来求解汉诺塔问题
 * @author nuonuo
 * @create 2020-12-20 16:48
 */
public class HanoiStack {
    public static void main(String[] args) {
        double start1 = System.currentTimeMillis();
        System.out.println(hanoi("left", "mid", "right", 10));
        double end1 = System.currentTimeMillis();
        double start2 = System.currentTimeMillis();
        System.out.println(hanoi1(10, "left", "mid", "right", "left", "right"));
        double end2 = System.currentTimeMillis();
        System.out.println(end1 - start1);
        System.out.println(end2 - start2);
    }
    /*
    TODO 非递归汉诺塔   用三个栈模拟三个位置
     */



    public static int hanoi(String a, String b, String c, int n) {
        if (n == 1) {
            print(n, a, b);
            print(n, b, c);
            return 2;
        }
        int part1 = hanoi(a, b, c, n-1);
        print(n, a, b);
        int part2 = hanoi(c, b, a, n-1);
        print(n, b, c);
        int part3 = hanoi(a, b, c, n-1);
        return part1 + part2 + part3 + 2;
    }

    public static int hanoi1(int num, String left, String mid, String right, String from, String to) {
        //1.如果只剩一个
        if (num == 1) {
            //2.判断是左 - 右还是左-中  还是 右-中
            if (from.equals("mid") || to.equals("mid")) {
                print(num, from, to);
                return 1;
            }
            print(num, from,"mid");
            print(num, "mid", to);
            return 2;
        }
        //3.不止一个就将上面num-1个先处理
        if (from.equals("mid") || to.equals("mid")) {
            String another = (from.equals(left) || to.equals(left)) ? right : left;
            int part1 = hanoi1(num-1, left,mid,right,from,another);
            int part2 = 1;
            print(num, from,to);
            int part3 = hanoi1(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            int part1 = hanoi1(num - 1, left, mid, right, from, to);
            int part2 = 1;
            print(num, from, "mid");
            int part3 = hanoi1(num-1, left,mid,right,to, from);
            int part4 = 1;
            print(num,mid,to);
            int part5 = hanoi1(num-1, left,mid,right,from,to);
            return part1 + part2 + part3 + part4 + part5;

        }

    }

    private static void print(int num, String from, String to) {
        System.out.println("Move " + num + " from " + from + " to " + to);
    }

}
