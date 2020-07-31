package exer05;

/**
 * 剑指offer36题：数组中的逆序对
 *
 * @author nuonuo
 * @create 2020-07-30 16:31
 */
public class T36 {
    int k = 0;//记录有多少个逆序对
    public static void main(String[] args) {
        T36 t36 = new T36();
        System.out.println(t36.InversePairs(new int[]{1, 2, 3, 4, 5, 6, 7, 0}));
    }
    public int InversePairs(int[] array) {
        //归并
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
        return k;

    }

    public void mergeSort(int[] array, int left, int right, int[] temp) {
        int mid = (left + right) / 2;
        if (left < right) {
            mergeSort(array, left, mid, temp);

            mergeSort(array, mid + 1, right, temp);

            merge(array, left, mid, right, temp);
        }
    }
    public void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left;//初始化i，表示左边有序序列的初始索引
        int j = mid + 1; // 初始化j，表示右边有序序列的初始索引
        int t = 0; //指向temp数组的当前索引

        //1.
        //先把左右两边（有序）的数据按照规则填充到temp数组
        //直到左右两边有一边处理完毕
        while(i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[t++] = array[i++];
            } else {//左边比右边大，除了填充数组，并且
                temp[t++] = array[j++];
                k += (mid-i+1);
                k %= 1000000007;
            }

        }

        //2.
        //把剩余的数据全部填充到temp
        while(i <= mid) {//左边剩余
            temp[t++] = array[i++];
        }
        while(j <= right) {//右边剩余
            temp[t++] = array[j++];
        }

        //3.
        //将temp数组的元素拷贝到arr
        //并不是每次都拷贝全部
        t = 0;
        int tempLeft = left; //
        while(tempLeft <= right) { // 第一次合并时tempLeft为0； right为1  第二次： tempLeft为2，right为3
            //最后一次合并tempLeft为0，right为7
            array[tempLeft++] = temp[t++];

        }
    }

}
