package com.cheng.other.蓝桥杯2020;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author nuonuo
 * @create 2021-03-28 11:38
 */
public class D七段码 {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        int[][] map = new int[7][7];
        init(map);//1.初始化七段码的关系图
        //2.将所有开灯的组合放在set
        for (int i = 1; i <= 7; i++) {
            combination("abcdefg".toCharArray(),0, i);
        }
        //3.然后结合关系图判断是否符合要求
        int res = check(map);
        System.out.println(res);
    }

    private static int check(int[][] map) {
        int res = 0;
        for (String s : set) {
            boolean flag1 = true;//表示s是否符合要求,符合要求表示s可以连通起来
            //判断连通的操作，先选出一个字符c，加入set，然后每一轮遍历s，将所有与c连接的字符加入set，
            // 直到有一轮没有任何字符加入set，就表示不连通；如果全部加入了，就表示连通
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(0));
            while (set.size() < s.length()) { //当全部加入了set，就表示连通,就退出循环
                boolean flag2 = false;//表示这一轮是否有字符加入set
                for (int i = 1; i < s.length(); i++) {
                    if (set.contains(s.charAt(i))) {
                        continue;
                    }
                    for (char c : set) {
                        if (map[s.charAt(i) - 97][c - 97] == 1) {
                            set.add(s.charAt(i));
                            flag2 = true;
                            break;
                        }
                    }
                }
                if (!flag2) {
                    flag1 = false;
                    break;
                }
            }
            if (flag1) {
                res++;
            }
        }
        return res;
    }

    private static void combination(char[] c, int k, int n) {
        if (k == n) {
            String s = new String(c, 0, n);
            //存放进去之前，将s按照字典序排序，为了将   ab  ba 这种情况合并成同一种结果
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            set.add(new String(chars));
        }
        for (int i = k; i < c.length; i++) {
            swap(c, i, k);
            combination(c, k+1, n);
            swap(c, i, k);
        }
    }

    private static void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    private static void init(int[][] map) {
        for (int i = 1; i < map.length - 1; i++) {
            map[i][i-1] = 1;
            map[i][i+1] = 1;
            map[i][i] = 1;
        }
        map[0][1] = 1; map[0][5] = 1; map[1][6] = 1;map[2][6] = 1;
        map[4][6] = 1; map[5][0] = 1;map[6][1] = 1; map[6][2] = 1;
        map[6][4] = 1; map[6][5] = 1;
    }
}
