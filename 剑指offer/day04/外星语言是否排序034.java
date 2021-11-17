package day04;

/**
 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。

 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。

 示例 1：
 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 输出：true
 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。

    思路：要点在于  给order进行hash  给每个单词一个优先级
            我的思路是 分别给每一位比较       题解有方法是  依次给相邻的两个单词比较
                这道题的经验：：！！！    写代码要避难就轻    比如：
                            1.数组的0位需要单独处理  ->   那就给他加个虚拟位，不要去单独处理    简洁！！！
 ·                          2.这道题我写的默认每个单词都判断26位   但单词参差不齐，
                                于其判断，不如直接将优先级赋为 -1

                要灵活！！！
 */
public class 外星语言是否排序034 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] t = new int[26];// 每个字母  -> 优先级   越小越高
        for (int i = 0; i < order.length(); i++) {
            t[order.charAt(i)-'a'] = i;
        }
        //1.比较每个单词位是否排序
        for (int i = 0; i < 26; i++) {
            int last = -1;
            boolean flag = true;//flag == true 表示当前单词位全部符合排序
            for (int j = 0; j < words.length; j++) {
                int cur = (words[j].length() <= i) ? -1 :
                        t[words[j].charAt(i)-'a'];//当前单词的当前位
                if (cur < last) {
                    return false;//比前面的单词小
                }
                flag = flag && (cur > last);
                last = cur;
            }
            if (last == -1 || flag) {
                //单词比较结束的两种情况
                //1.当前单词位没有单词可比了
                //2.当前单词位比较符合排序规则
                break;
            }
        }
        return true;

    }
}
