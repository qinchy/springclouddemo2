package com.qinchy.springclouddemoprovider1.domain.algorithm.anagram;

public class Anagram2 {
    public static boolean isAnagram(String s, String t) {
        char[] chars = new char[26];

        // 出现在s里面的字符加，然后将出现在t的字符减，最后为0时表示个数相等
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            chars[c - 'a']--;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0)
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
