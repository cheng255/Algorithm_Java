package exer05;

import java.util.HashMap;

/**
 * 剑指offer35：第一次出现一次的字符
 *
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * @author nuonuo
 * @create 2020-07-29 16:08
 */
public class T35 {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0){
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);
            if(map.containsKey(temp)){
                map.put(temp, map.get(temp)+1);
                continue;
            }
            map.put(temp, 1);
        }
        for(int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);
            if(map.get(temp) == 1){
                return i;
            }
        }
        return -1;
    }
}
