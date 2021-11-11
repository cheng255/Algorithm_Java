package day02;

/**
 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 本题中，将空字符串定义为有效的 回文串 、
 示例 1:

 输入: s = "A man, a plan, a canal: Panama"
 输出: true
 解释："amanaplanacanalpanama" 是回文串
 示例 2:
 输入: s = "race a car"
 输出: false
 解释："raceacar" 不是回文串
 提示：
 1 <= s.length <= 2 * 105
 字符串 s 由 ASCII 字符组成


    easy   双指针
 */
public class 有效的回文018 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left += 1;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right -= 1;
            } else {
                char char1 = Character.toLowerCase(s.charAt(left++));
                char char2 = Character.toLowerCase(s.charAt(right--));
                if (char1 != char2) {
                    return false;
                }
            }
        }
        return true;
    }

}
