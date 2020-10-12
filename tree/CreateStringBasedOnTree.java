package com.cheng.tree;

/**
 * LeetCodeT606. 根据二叉树创建字符串
 * @author nuonuo
 * @create 2020-10-12 18:35
 */
public class CreateStringBasedOnTree {
    public String tree2str(Node t) {
        StringBuilder sb = new StringBuilder();
        if (t == null) {
            return "";
        }
        tree2str1(t, sb);
        return sb.toString();
    }
    public void tree2str1(Node t, StringBuilder sb) {
        //递归思想
        //先添加当前结点，然后判断
        if (t != null) {
            sb.append(t.val);
            if (t.left == null && t.right == null) {
                return;
            } else if (t.right == null) { // 左不空右空
                sb.append('(');
                tree2str1(t.left, sb);
                sb.append(')');
            } else {
                sb.append('(');
                tree2str1(t.left, sb);
                sb.append(')');
                sb.append('(');
                tree2str1(t.right, sb);
                sb.append(')');
            }
        }
    }
}
