package com.cheng.other.蓝桥杯2020;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author nuonuo
 * @create 2021-03-28 10:17
 */
public class B寻找2020 {
    public static void main(String[] args) throws FileNotFoundException {
        int[][] arr = input();//读取文件操作
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                //1.先拿到每一个元素
                if (arr[i][j] == 0) continue;//如果是0就跳过
                //2.如果是2就分三路去搜索
                if (j + 3 < arr[i].length && arr[i][j+1] == 0 &&
                        arr[i][j+2] == 2 && arr[i][j+3] == 0) {
                    res++;
                }//向右
                if (i + 3 < arr.length && arr[i+1][j] == 0 &&
                        arr[i+2][j] == 2 && arr[i+3][j] == 0) {
                    res++;
                }//向下
                if (i + 3 < arr.length && j + 3 < arr[i].length &&
                        arr[i+1][j+1] == 0 && arr[i+2][j+2] == 2 && arr[i+3][j+3] == 0) {
                    res++;
                }//向右下侧
            }
        }
        System.out.println(res);

    }
    private static int[][] input() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(new File("D:\\workspace_idea\\javaSenior\\leetcode\\2020.txt"));
        Scanner sc = new Scanner(fis);
        List<String> list = new ArrayList<>();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            list.add(s);
        }
        int[][] arr = new int[list.size()][list.get(0).length()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                arr[i][j] = list.get(i).charAt(j) - 48;
            }
        }
        return arr;
    }
}
