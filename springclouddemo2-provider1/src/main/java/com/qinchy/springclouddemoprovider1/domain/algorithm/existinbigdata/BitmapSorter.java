package com.qinchy.springclouddemoprovider1.domain.algorithm.existinbigdata;

public class BitmapSorter {
    public static void main(String[] args) {
        int[] arr = {1, 7, -3, 0, 0, 6, 6, 9, -11};
//        bitmapSort(arr);
//        for (int i : arr) {
//            System.out.print(i + " , ");
//        }

        System.out.println(isContain(arr, 6));
    }

    /**
     * 使用位图法进行排序
     *
     * @param arr
     */
    public static void bitmapSort(int[] arr) {
        // 找出数组中最值
        int max = arr[0];
        int min = max;
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
            if (min > i) {
                min = i;
            }
        }

        // 得到位图数组
        int[] newArr = new int[max - min + 1];
        for (int i : arr) {
            int index = i - min;
            newArr[index]++;
        }

        System.out.println();
        // 重整arr中的元素
        int index = 0;
        for (int i = 0; i < newArr.length; i++) {
            while (newArr[i] > 0) {
                arr[index] = i + min;
                index++;
                newArr[i]--;
            }
        }
    }

    public static boolean isContain(int[] arr, int value) {
        // 找出数组中最值
        int max = arr[0];
        int min = max;
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
            if (min > i) {
                min = i;
            }
        }

        // 得到位图数组
        int[] newArr = new int[max - min + 1];
        for (int i : arr) {
            int index = i - min;
            newArr[index]++;
        }

        // 下标必须再这个范围内，且值必须大于0
        return (value - min < newArr.length - 1) && (newArr[value - min] > 0);
    }
}