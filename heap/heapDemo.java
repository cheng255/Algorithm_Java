package com.cheng.heap;

/**
 * 堆的应用：
 * 1.优先级队列
 * 2.排序
 * 3.TopK 思路：建立K个元素的小根堆，然后依次向后遍历，每个元素和堆顶元素比较（挑战） 如果大于就替换，然后向下调整
 *
 * //有关堆的基本操作（小根堆）
 * @author nuonuo
 * @create 2020-10-16 12:39
 */
public class heapDemo {


    public void createHeap(int arr[]) {
        //思路： 將每个非叶子结点都向下调整
        // 最后一个结点的父结点下标设为par   需要调整的区间就是[0,par]
        int par = (arr.length - 2) / 2;
        for (int i = par; i >= 0; i--) {
            adjustDown(arr, i, arr.length);
        }
    }


    /**
     *  向下调整
     * @param arr : 堆存储的数组
     * @param index ： 需要调整的元素下标
     * @param size ： 堆的大小
     */
    public void adjustDown(int arr[], int index, int size) {
        while (index * 2 + 1 < size) {
            //当需要调整的元素不存在或者它没有孩子时，直接返回
//            if (index * 2 + 1 >= size) {
//                return;
//            }
            //找到孩子中较小的
            int min;
            if (index * 2 + 2 >= size || arr[index * 2 + 1] > arr[index * 2 + 2]) {
                min = index * 2 + 1;
            } else {
                min = index * 2 + 2;
            }
            //将min和arr[index]比较
            if (arr[index] > arr[min]) { //如果当前元素更大， 就向下置换
                {int temp = arr[index]; arr[index] = arr[min]; arr[min] = temp;}
            }
            index = min;
        }

    }

    /**
     *
     * @param arr 堆存储的数组
     * @param index 需要调整的元素下标
     * @param size 堆的大小
     */
    public void adjustUp(int arr[], int index, int size) {
        //将该元素与他的父结点比较， 如果小于父结点 就向上置换
        while (true) {
            int par = (index - 1) / 2; // 父结点的下标
            if (par <= 0 || arr[par] < arr[index]) {
                return;
            }
            int temp = arr[index]; arr[index] = arr[par]; arr[par] = temp;

            index = par;
        }
    }
}
