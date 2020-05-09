package com.qinchy.springclouddemoprovider1.domain.algorithm.middle;

import java.util.PriorityQueue;

/**
 * 求一个无序数组的中位数
 * 求一个无序数组的中位数。
 * 如：{2,5,4,9,3,6,8,7,1}的中位数为5，{2,5,4,9,3,6,8,7,1,0}的中位数为4和5。
 * 要求：不能使用排序，时间复杂度尽可能低。
 * 提示：考虑堆或者快排思想解决
 */
public class MiddleNumFinder {

    private static double helper(int[] array) {
        int heapSize = array.length / 2 + 1;
        // PriorityQueue通过二叉小顶堆实现，可以用一棵完全二叉树表示。
        PriorityQueue<Integer> heap = new PriorityQueue<>(heapSize);
        for (int i = 0; i < heapSize; i++) {
            // offer向优先队列中插入元素
            heap.offer(array[i]);
        }

        // 把剩下的值填充到heap
        for (int i = heapSize; i < array.length; i++) {
            // peek获取但不删除队首元素
            int i1 = array[i];
            // 如果元素大于堆顶，则弹出堆顶，并将新元素放入
            if (i1 > heap.peek()) {
                heap.poll();
                heap.offer(i1);
            }
        }

        // 奇数就是堆顶
        if (array.length % 2 == 1) {
            return (double) heap.peek();
        } else {
            // poll获取并删除队首元素
            return (double) (heap.poll() + heap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 4, 9, 3, 6, 8, 7, 1};
        double middleNum = helper(array);
        System.out.println(middleNum);
    }
}
