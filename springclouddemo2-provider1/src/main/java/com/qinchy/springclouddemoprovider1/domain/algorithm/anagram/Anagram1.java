package com.qinchy.springclouddemoprovider1.domain.algorithm.anagram;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

public class Anagram1 {
    public static boolean isAnagram(@NotNull String s, @NotNull String t) {
        if (s.length() != t.length())
            return false;

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "nagaram";
        System.out.println(isAnagram(s1, s2));
    }
}
