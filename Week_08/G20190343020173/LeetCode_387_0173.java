package org.crayzer.leetcode.editor.en.string;

import java.util.HashMap;

public class LeetCode_387_FirstUniqueCharacterInAString {
    class Solution1 {
        public int firstUniqChar(String s) {
            int[] letters = new int[26];
            for (int i = 0; i < s.length(); i++) letters[s.charAt(i) - 'a']++;
            for (int i = 0; i < s.length(); i++) {
                if (letters[s.charAt(i) - 'a'] == 1) return i;
            }
            return -1;
        }
    }

    class Solution {
        public int firstUniqChar(String s) {
            HashMap<Character, Integer> count = new HashMap<Character, Integer>();
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                count.put(c, count.getOrDefault(c, 0) + 1);
            }

            for (int i = 0; i < n; i++) {
                if (count.get(s.charAt(i)) == 1)
                    return i;
            }
            return -1;
        }
    }
}
