package org.crayzer.leetcode.editor.en.string;

import java.util.HashMap;

public class LeetCode_205_IsomorphicStrings {

    class Solution1 {
        public boolean isIsomorphic(String s, String t) {
            int n = s.length();
            int[] s1 = new int[128];
            int[] t1 = new int[128];

            for (int i = 0; i < n; i++) {
                int c1 = s.charAt(i);
                int c2 = t.charAt(i);
                if (s1[c1] != t1[c2]) return false;
                else {
                    if (s1[c1] == 0) {
                        s1[c1] = i + 1;
                        t1[c2] = i + 1;
                    }
                }
            }
            return true;
        }
    }

    class Solution {
        public boolean isIsomorphic(String s, String t) {
            return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
        }

        private boolean isIsomorphicHelper(String s, String t) {
            int n = s.length();
            HashMap<Character, Character> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);
                if (map.containsKey(c1)) {
                    if (map.get(c1) != c2) return false;
                } else map.put(c1, c2);
            }
            return true;
        }
    }
}
