package com.cheng.string;

/**
 * LeetCode T273: 整数转换英文表示
 * 将非负整数转换为其对应的英文表示。可以保证给定输入小于 2^31 - 1 。
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: "One Hundred Twenty Three"
 * 示例 2:
 * <p>
 * 输入: 12345
 * 输出: "Twelve Thousand Three Hundred Forty Five"
 * 示例 3:
 * <p>
 * 输入: 1234567
 * 输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 示例 4:
 * <p>
 * 输入: 1234567891
 * 输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven
 * Thousand Eight Hundred Ninety One"
 *
 * @author nuonuo
 * @create 2020-09-09 15:33
 */
public class IntegerToEnglishWords {
    public static void main(String[] args) {
        System.out.println(numberToWords(300000));
    }
    private static String numberToWords(int num) {
//        000 000 000 000 000
        if (num == 0) {
            return "Zero";
        }
        int billion = num / 1000000000;
        int million = (num - billion * 1000000000) / 1000000;
        int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
        int rest = num % 1000; // 个十百
        StringBuilder res = new StringBuilder();

        if (billion != 0) {
            res.append(three(billion)).append(" Billion");
        }
        if (million != 0) {
            if (res.length() != 0) {
                res.append(" ");
            }
            res.append(three(million)).append(" Million");
        }
        if (thousand != 0) {
            if (res.length() != 0) {
                res.append(" ");
            }
            res.append(three(thousand)).append(" Thousand");
        }
        if (rest != 0) {
            if (res.length() != 0) {
                res.append(" ");
            }
            res.append(three(rest));
        }
        return res.toString();
    }

    private static String three(int num) {
        StringBuilder sb = new StringBuilder();
        int hundred = num / 100;
        int tenOne = num % 100;
        if (hundred != 0) {
            sb.append(one(hundred)).append(" Hundred");
        }
        if (tenOne == 0) {
            return sb.toString();
        }
        if (sb.length() != 0) {
            sb.append(" ");
        }
        if (tenOne < 10) { //只有个位
            sb.append(one(tenOne));
        } else if (tenOne < 20) { // 10 ~ 19
            sb.append(oneToNineteen(tenOne));
        } else { // >20
            sb.append(ten(tenOne / 10));
            if (tenOne % 10 != 0) {
                sb.append(" ").append(one(tenOne % 10));
            }
        }
        return sb.toString();
    }

    private static String one(int num) {
        switch (num) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
        }
        return "";
    }

    private static String oneToNineteen(int num) {
        switch (num) {
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
        }
        return "";
    }

    private static String ten(int num) {
        switch (num) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
        }
        return "";
    }
}
