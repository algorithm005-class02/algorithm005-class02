package org.crayzer.leetcode.editor.en.hash;

import java.util.Arrays;

public class LeetCode_242_ValidAnagram {

    /**
     * O(n)
     */
    class Solution2 {
        public boolean isAnagrams(String s, String t) {
            if (s.length() != t.length()) return false;

            int[] counter = new int[26];
            for (int i = 0; i < s.length(); i++) {
                counter[s.charAt(i) - 'a']++;
                counter[t.charAt(i) - 'b']--;
            }

            for (int count : counter) {
                if (count != 0) return false;
            }

            return true;
        }
    }

    /**
     * O(nlogn)
     */
    class Solution1 {
        public boolean isAnagrams(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            char[] s2Chars = s.toCharArray();
            char[] t2Chars = t.toCharArray();

            Arrays.sort(s2Chars);
            Arrays.sort(t2Chars);
            return Arrays.equals(s2Chars, t2Chars);
        }
    }
}
