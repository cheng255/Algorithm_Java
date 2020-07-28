package exer05;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * 剑指offer30题：最小的k个数
 * @author nuonuo
 * @create 2020-07-27 11:59
 */
public class T30 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4);
        System.out.println(integers);
        PriorityQueue<Integer> integers1 = new PriorityQueue<>();
    }



    private static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(input == null || input.length <= k || k <= 0){
            return res;
        }
        int[] par = partition(input, 0, input.length - 1);
        while(k-1 < par[0] || k-1 > par[1]){//没找到第k小的元素就一直找
            if(k-1 < par[0]){
                par = partition(input, 0, par[0]-1);
            }
            if(k-1 > par[1]){
                par = partition(input, par[1]+1, input.length-1);
            }
        }
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        res.sort((o1, o2) -> o1 - o2);
        return res;
    }


    //将比point小的数放在左边，大的在右边，相等在中间
    private static int[] partition(int[] arr, int left, int right){
        int less = left-1;//小于区域的边界
        int more = right+1;//大于区域的边界
        int point = arr[left];
        while(left < right){
            if(arr[left] < point){
                swap(arr, ++less, left++);
            }else if(arr[left] > point){
                swap(arr, --more, left++);
            }else{
                left++;
            }
        }
        return new int[]{less, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
