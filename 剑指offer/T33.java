package exer05;


import java.util.Arrays;

/**
 * 剑指offer32题：把数组排成最小的数
 * @author nuonuo
 * @create 2020-07-28 20:04
 *
 * 分析：自定义排序  如果 a+b > b+a  那么我们会希望把b放在前面
 */
public class T33 {
    public static void main(String[] args) {
        System.out.println(PrintMinNumber(new int[]{3, 32, 321}));
    }
    private static String PrintMinNumber(int [] numbers) {
        String[] res = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            res[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(res, (o1, o2) -> {
            return o1.concat(o2).compareTo(o2.concat(o1));
        });
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            s.append(res[i]);
        }
        return new String(s);
    }
}
