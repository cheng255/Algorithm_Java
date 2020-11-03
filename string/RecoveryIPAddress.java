package com.cheng.string;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCodeT93. 复原IP地址
 *
 * 思路：用递归回溯的方法  先穷举第一段 然后递归穷举后三段，最后一段特殊处理
 * @author nuonuo
 * @create 2020-11-03 15:52
 */
public class RecoveryIPAddress {
    public static void main(String[] args) {

    }
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(s, 0, sb, res);// k 初始化 0 表示当前为第1段地址
        return res;
    }
    private void helper(String s, int k, StringBuilder sb, List<String> res) {
        if (k == 3) {
            //只需要判断剩余的是否符合要求然后return
            if (s.length() > 0 && s.length() < 4 && check(s)) {
                sb.append(s);
                res.add(sb.toString());//符合要求的一组数据
                sb.delete(sb.length() - s.length(),sb.length());//回溯
            }

            return;
        }
        //思路：递归思想  先确定第一个地址段然后加. 然后递归增加剩下三段地址
        int i;
        for (i = 0; i < 3; i++) { //该段地址的长度为1——3  穷举所有该段地址的可能
            if (i >= s.length() || !check(s.substring(0,i+1))) {//检查当前段地址
                break;
            }
            int j = 0;
            while (j <= i) {sb.append(s.charAt(j)); j++;}
            sb.append(".");
            //第一段添加完成

            helper(s.substring(i+1), k+1, sb, res);//递归添加后面段落
            sb.delete(sb.length() - 2 - i,sb.length());//回溯
        }
    }
    /*
    检查s 是否为 0 —— 255
     */
    private boolean check(String s) {
        if ((s.charAt(0) == '0' && s.length() != 1)) {
            return false;
        }
        if (s.length() < 3) {
            return true;
        }
        //到这都是长度为3 而且第一位不是0
        if (s.charAt(0) > '2') {
            return false;
        } else if (s.charAt(0) < '2') {
            return true;
        } else {
            if (s.charAt(1) > '5') {
                return false;
            } else if (s.charAt(1) < '5') {
                return true;
            } else {
                if (s.charAt(2) > '5') {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }
}

