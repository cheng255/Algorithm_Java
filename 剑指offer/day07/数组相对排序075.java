package day07;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * 示例：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * 提示：
 * <p>
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * <p>
 * 思路：1.我做的方法 是用hashMap计数， 然后剩下的再进行排序
 * <p>
 * 2.因为数并不多   最大1000 所以直接用数组计数，还省去的排序的步骤。
 */
public class 数组相对排序075 {
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : arr1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int[] res = new int[arr1.length];
        int i = 0;

        for (int n : arr2) {
            int v = map.remove(n);
            Arrays.fill(res, i, i + v, n);
            i += v;
        }
        int[] temp = new int[arr1.length - i];
        int j = 0;
        for (int n : map.keySet()) {
            int v = map.get(n);
            Arrays.fill(temp, j, j + v, n);
            j += v;
        }
        Arrays.sort(temp);
        for (int n : temp) {
            res[i++] = n;
        }
        return res;
        
    }
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int maxValue = 0;//最大值记录
        for (int n : arr1) {
            maxValue = Math.max(maxValue, n);
        }
        int[] vals = new int[maxValue+1];
        for (int n : arr1) {//计数
            vals[n]++;
        }
        int[] res = new int[arr1.length];int i = 0;
        for (int n : arr2) {
            int v = vals[n];
            vals[n] = 0;
            Arrays.fill(res, i, i+v, n);
            i += v;
        }
        for (int n = 1; n < vals.length; n++) {
            if (vals[n] != 0) {
                int v = vals[n];
                Arrays.fill(res, i, i+v, n);
                i += v;
            }
        }
        return res;

    }
}
