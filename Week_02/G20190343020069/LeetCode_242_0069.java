package leetcode.week02;

import java.util.Arrays;

/**
 * 异位词
 *什么是异位词：
 * 1、包含的字母一样
 * 2、每个字符出现的频率一样
 * 3、顺序不同
 */
public class LeetCode_242_0069 {
    /**
     * 判断两个词是否互为异位词
     * 解题思路：
     * 1、首先对两个词转成chartArray
     * 2、对两个chartArray进行sort
     * 3、比较两个chartArray is equals?
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isAnagram (String s1 , String s2) {
        /**
         * 解法1：排序法
         * 时间复杂度 O(nlogn) 主要是排序所用的复杂度
         * Java中，toCharArray 进行了字符串的拷贝，空间复杂度为O(n)
         */
        //首先长度需要相等
//        if (s1.length() != s2.length()) {
//            return false;
//        }
//        //toCharArray
//        char [] char1 = s1.toCharArray();
//        char [] char2 = s2.toCharArray();
//
//        //sort
//        Arrays.sort(char1);
//        Arrays.sort(char2);
//
//        return Arrays.equals(char1 , char2);
        /**
         * 解法2：哈希表 国际站 most votes
         * 时间复杂度O(n) 空间复杂度O(1)
         *The idea is simple.
         * It creates a size 26 int arrays as buckets for each letter in alphabet.
         * It increments the bucket value with String s
         * and decrement with string t.
         * So if they are anagrams, all buckets should remain with initial value which is zero.
         * So just checking that and return
         */
        int[] alphabet = new int[26];
        for (int i = 0; i < s1.length(); i++) alphabet[s1.charAt(i) - 'a']++;
        for (int i = 0; i < s2.length(); i++) alphabet[s2.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }


    public static void main (String args []) {
        //test cases
        String s1 = "anagram";
        String s2 = "nagaram";
        System.out.println(isAnagram(s1,s2));
    }
}
