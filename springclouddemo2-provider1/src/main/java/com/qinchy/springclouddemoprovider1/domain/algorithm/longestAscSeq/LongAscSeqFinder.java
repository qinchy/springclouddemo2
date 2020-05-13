package com.qinchy.springclouddemoprovider1.domain.algorithm.longestAscSeq;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 找最长不下降子序列
 * 首先从自己开始算，自己也能组成不讲序列，然后向后轮询，只要候面的数大于等于前一个数，那么最长不将子序列的长度就加1.
 */
public class LongAscSeqFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N + 1];

        // dp用来记录点i到n的最长不下降子序列的长度
        int[] dp = new int[N + 1];
        A[0] = 0;
        for (int i = 1; i <= N; i++) {
            A[i] = scanner.nextInt();
        }

        Arrays.fill(dp, 1);
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (A[i] >= A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); //状态转移方程
                    System.out.print(A[j]);
                }
            }
            System.out.print(A[i]);
            System.out.println();
        }
        Arrays.sort(dp);
        System.out.println(dp[N]);
    }
}