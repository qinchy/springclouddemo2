package com.qinchy.springclouddemoprovider1.domain.algorithm.longestAscSeq;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreaseSeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 序列的大小
        int size = scanner.nextInt();
        // 构造原始序列
        int[] a = new int[size];
        // 记录以每一个元素结尾的最长子序列的长度值
        int[] dp = new int[size];

        // 从键盘输入构造原始序列
        for (int i = 0; i < size; i++) {
            a[i] = scanner.nextInt();
        }

        Arrays.fill(dp, 1);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    System.out.print(a[j] + " ");
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            System.out.println(a[i]);
        }

        // 输出结果
        for (int i = 0; i < dp.length; i++) {
            System.out.println("以 " + a[i] + " 结尾的最长子序列长度为 " + dp[i]);
        }

        System.out.println();
    }
}
