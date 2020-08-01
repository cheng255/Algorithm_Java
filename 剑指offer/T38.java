package exer05;

/**
 * 剑指offer38题：统计一个数字在排序数组中出现的次数
 * <p>
 * <p>
 * 分析：用二分查找找到第一个k个最后一个k
 *
 * 注意 要防止下标越界
 *
 * @author nuonuo
 * @create 2020-07-31 10:08
 */
public class T38 {

    public static void main(String[] args) {
        T38 t38 = new T38();
        System.out.println(t38.GetNumberOfK(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3));
    }
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int firstK = getFirstK(array, k);
        int lastK = getLastK(array, k);
        System.out.println("f" + firstK);
        System.out.println("l" + lastK);
        if (firstK == -1 || firstK == -1) {
            return 0;
        }
        return lastK - firstK + 1;
    }

    /*
    找到数组中第一个k，找不到返回-1
     */
    public int getFirstK(int[] array, int k) {
        int l = 0, r = array.length - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (array[mid] < k) {
                l = mid + 1;
            } else if (array[mid] == k && (mid == 0 || array[mid - 1] != k)) { //找到了第一个k
                return mid;
            } else { //只要不是第一个k就继续向后找
                r = mid - 1;
            }
        }
        return -1;
    }

    /*
    找到数组中最后一个k，找不到返回-1
     */
    public int getLastK(int[] array, int k) {
        int l = 0, r = array.length - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (array[mid] > k) {
                r = mid - 1;
            } else if (array[mid] == k && (mid == array.length-1 || array[mid + 1] != k)) { //找到了最后一个k
                return mid;
            } else { //只要不是最后一个k就继续向后找
                l = mid + 1;
            }
        }
        return -1;
    }
}
