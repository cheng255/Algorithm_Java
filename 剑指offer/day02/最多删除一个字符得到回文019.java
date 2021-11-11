package day02;

/**
 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。

  

 示例 1:

 输入: s = "aba"
 输出: true
 示例 2:

 输入: s = "abca"
 输出: true
 解释: 可以删除 "c" 字符 或者 "b" 字符
 示例 3:

 输入: s = "abc"
 输出: false
  

 提示:

 1 <= s.length <= 105
 s 由小写英文字母组成


 easy    就是找到不相同的地方   然后只有两种可能    删除左边和删除右边
        2是1的封装版
 */
public class 最多删除一个字符得到回文019 {
    public boolean validPalindrome2(String s) {
        int left = 0, right = s.length()-1;
        while (left <= right) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if (c1 != c2) { //找到了不相同的那两个字符，现在有两条路  删左和删右
                return func(s, left+1, right) || func(s, left, right-1);
            }
            left++; right--;
        }
        return true;
    }
    public boolean func(String s, int left, int right) {
        while (left <= right) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if (c1 != c2) {
                return false;
            }
            left++; right--;
        }
        return true;
    }

    public boolean validPalindrome1(String s) {
        int left = 0, right = s.length()-1;
        while (left <= right) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if (c1 != c2) {
                break;
            }
            left++; right--;
        }
        if (left > right) {
            return true;
        }
        //找到了不相同的那两个字符，现在有两条路  删左和删右
        int left1 = left+1, right1 = right;
        while (left1 <= right1) {
            char c1 = s.charAt(left1);
            char c2 = s.charAt(right1);
            if (c1 != c2) {
                break;
            }
            left1++; right1--;
        }
        if (left1 > right1) {
            return true;
        }
        int left2 = left, right2 = right-1;
        while (left2 <= right2) {
            char c1 = s.charAt(left2);
            char c2 = s.charAt(right2);
            if (c1 != c2) {
                return false;
            }
            left2++; right2--;
        }
        return true;

    }
}
