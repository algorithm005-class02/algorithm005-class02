package org.crayzer.leetcode.editor.en.hash;

import java.util.*;

public class LeetCode_49_GroupAnagrams {

    /**
     * O(nk)
     **/
    class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) return new ArrayList<>();

            Map<String, List<String>> ans = new HashMap<>(16);
            int[] counter = new int[26];

            for (String s : strs) {
                Arrays.fill(counter, 0);
                for (char c : s.toCharArray()) counter[c - 'a']++;

                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    stringBuilder.append("#");
                    stringBuilder.append(counter[i]);
                }

                String key = stringBuilder.toString();
                if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
                ans.get(key).add(s);
            }

            return new ArrayList<>(ans.values());
        }
    }

    /**
     * O(n*k*logk)
     **/
    class Solution1 {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) return new ArrayList<>();

            Map<String, List<String>> ans = new HashMap<>(16);
            for (String s : strs) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String key = String.valueOf(chars);

                if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());

                ans.get(key).add(s);
            }

            return new ArrayList<>(ans.values());
        }
    }
}
