package org.crayzer.leetcode.editor.en.string;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_438_FindAllAnagramsInAString {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int count = p.length();
            int[] map = new int[26];
            for (char c : p.toCharArray()) map[c - 'a']++;
            List<Integer> res = new LinkedList<>();

            int left = 0, right = 0;
            while (right < s.length()) {
                if (map[s.charAt(right) - 'a'] > 0) count--;
                map[s.charAt(right++) - 'a']--;

                while (count == 0) {
                    if (right - left == p.length()) {
                        res.add(left);
                    }

                    if (map[s.charAt(left) - 'a'] == 0) count++;
                    map[s.charAt(left++) - 'a']++;
                }
            }
            return res;
        }
    }
}
