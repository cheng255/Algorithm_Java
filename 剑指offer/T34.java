package exer05;

/**
 *
 * 剑指offer34题：丑数
 *
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * //思路：
 *
 *      丑数分为三个序列  *2的序列  *3的序列    *5的序列
 *
 *      我们需要从每一轮序列中选出最小的丑数，依此来对丑数排序
 * @author nuonuo
 * @create 2020-07-29 15:18
 */
public class T34 {

    private static int GetUglyNumber_Solution(int index) {
        if(index <= 0){
            return 0;
        }
        int[] ugly = new int[index];//存放丑数
        ugly[0] = 1;//第一个丑数是1
        int p2 = 0, p3 = 0, p5 = 0;//分别表示三个序列
        for(int i = 1; i < index; i++){
            int curUgly = ugly[i-1];//表示当前数组中最大的排在最后面的丑数
            while(curUgly >= 2*ugly[p2]){p2++;}
            while(curUgly >= 3*ugly[p3]){p3++;}
            while(curUgly >= 5*ugly[p5]){p5++;}
            //选出此轮最小的丑数并加入数组
            ugly[i] = Math.min(Math.min(2 * ugly[p2], 3 * ugly[p3]), 5 * ugly[p5]);
        }
        return ugly[index-1];
    }
}
