package exer05;

/**
 * 剑指offer40题:数组中只出现一次的数字
 *
 *
 * 分析：
 * 由于如果只有一个只出现一次的数，就可以经过一次异或运算，结果就是这个数
 *
 * 由此可得 有两个只出现一次的数时
 * 1.全部异或一遍，结果肯定也不为0
 * 2.根据结果以第n位是不是0为条件将数组分成两部分，使得每部分都有一个只出现一次的数
 * 3.然后异或运算得到结果
 * @author nuonuo
 * @create 2020-08-01 21:15
 */
public class T40 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int XOR1 = 0;
        for (int n : array) {
            XOR1 ^= n;
        }
        //找到当前XOR1的1位   因为异或运算后相当于是这两个只出现一次的数之间异或运算，
        // 所以可以用1位来给他们分组，并且也正好可以给其他数字分组，保证相同的数字能被分到一组
        int temp = (int)Math.pow(2, get(XOR1));
        int[] arr1 = new int[array.length];
        int[] arr2 = new int[array.length];
        int i = 0, j = 0;
        for (int n : array) {
            if ((temp & n) == 0) {
                arr1[i++] = n;
            } else {
                arr2[j++] = n;
            }
        }
        //分组后再分别异或运算
        for (int n : arr1) {
            num1[0] ^= n;
        }
        for (int n : arr2) {
            num2[0] ^= n;
        }

    }
    //找到n的二进制为1的位  00000100 -> 2
    public int get(int n) {

        int i = 0;
        while ((n & 1) != 1) {
            n >>= 1;
            i++;
        }
        return i;
    }

    //改进，找到n的二进制第一个为1的位置 可以用 n & -n 得到
     //改进后的代码
    public void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        int XOR1 = 0;
        for (int n : array) {
            XOR1 ^= n;
        }
        int res = XOR1 ^ (-XOR1);
        for (int n : array) {
            if ((n & (int)(Math.pow(2, res))) == 0) {
                num1[0] ^= n;
            } else {
                num2[0] ^= n;
            }
        }
    }
}
