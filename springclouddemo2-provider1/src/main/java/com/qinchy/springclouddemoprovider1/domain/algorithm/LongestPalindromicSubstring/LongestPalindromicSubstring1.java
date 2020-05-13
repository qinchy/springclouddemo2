package com.qinchy.springclouddemoprovider1.domain.algorithm.LongestPalindromicSubstring;

import javax.validation.constraints.NotNull;

// https://blog.csdn.net/tiankong_12345/article/details/102018257
public class LongestPalindromicSubstring1 {
    public static void main(String[] args) {
        String src = "abceffec";
        System.out.println(longestPalindrome(src));
    }

    public static String longestPalindrome(@NotNull String s) {
        int size = s.length();
        int maxLen = 0;
        String ans = "";
        boolean[][] p = new boolean[size][size];
        // lengthPosition为长度下标：1...length
        for (int lengthPosition = 1; lengthPosition <= size; lengthPosition++) {
            for (int start = 0; start < size; start++) {
                int subLength = start + lengthPosition - 1;
                // 下标越界，结束循环
                if (subLength >= size) {
                    break;
                }

                p[start][subLength] = (lengthPosition == 1 || lengthPosition == 2 || p[start + 1][subLength - 1]) && s.charAt(start) == s.charAt(subLength);
                if (p[start][subLength] && lengthPosition > maxLen) {
                    maxLen = lengthPosition;
                    ans = s.substring(start, subLength + 1);
                }
            }
        }
        return ans;
    }
}
