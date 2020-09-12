package com.cheng.string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * LeetCode T68. 文本左右对齐
 *
 * @author nuonuo
 * @create 2020-09-12 21:25
 */
public class AlignTextleftAndRight {
    public static void main(String[] args) {
        List<String> res = fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);
        Iterator<String> iterator = res.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        sb.append(words[0]);
        int n = 1; // n 记录每一行的字符串的数量
        for (int i = 1; i < words.length; i++) {
            if (sb.length() + words[i].length() + 1 <= maxWidth) {
                sb.append(" ").append(words[i]);
                n++;
                continue;
            }
            // 要换行了
            // 这时候往res里加前 先填补空格 做到左右对齐的效果
            fillBlanks(sb, maxWidth, n);
            res.add(sb.toString());
            sb.delete(0, sb.length()).append(words[i]);
            n = 1; // 换行了 所以重置
        }
        fillBlanks(sb, maxWidth, 1);//最后一行，左对齐
        res.add(sb.toString());

        return res;
    }

    private static void fillBlanks(StringBuilder sb, int maxWidth, int n) {
        if (sb.length() == maxWidth) {
            return;
        }
        if (n == 1) {
            while (sb.length() < maxWidth) {
                sb.append(' ');
            }
            return;
        }
        int blanks = (maxWidth - sb.length() + 1) / (n - 1); //每个空格处该加的空格
        // 还有blanks == 0的情况
        int k = maxWidth - sb.length();
        if (blanks == 0) { // 空格不够分时
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) != ' ') {
                    continue;
                }
                // 遇到空格就加一次空格
                sb.insert(i++, ' ');
                k--;
                if (k == 0) {
                    return;
                }

            }
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != ' ') {
                continue;
            }
            // 遇到空格
            for (int j = 0; j < blanks; j++) {
                sb.insert(i++, ' ');
            }
            if (sb.length() > maxWidth) { // 将多余的空格去掉
                sb.deleteCharAt(--i);
            }
        }
        if (sb.length() < maxWidth) {
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) != ' ') {
                    continue;
                }
                // 遇到空格
                sb.insert(i++, ' ');
                break;
            }
        }
    }
}
