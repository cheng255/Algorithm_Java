package exer05;

/**
 * 剑指offer31题：连续子数组的最大值
 * （DP）
 * @author nuonuo
 * @create 2020-07-27 15:27
 */
public class T31 {
    public static void main(String[] args) {
        System.out.println(FindGreatestSumOfSubArray(new int[]{6, -3, -2, 7, -15, 1, 2, 2}));
    }

    /**
     * 利用动态规划，分析：sum[i]表示以i结尾最大的和，如果sum[i-1]<0,那sum[i]就等于arr[i]，否则就等于sum[i-1]+arr[i]
     * @param array
     * @return
     */
    private static int FindGreatestSumOfSubArray(int[] array) {
        int[] sum = new int[array.length];
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if(i == 0 || sum[i-1] < 0) {
                sum[i] = array[i];
            }else{
                sum[i] = sum[i-1] + array[i];
            }
            max = (sum[i] > max) ? sum[i] : max;
        }
        return max;
    }
}
