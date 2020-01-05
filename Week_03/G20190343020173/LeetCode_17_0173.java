package org.crayzer.leetcode.editor.en.分治_回溯;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LeetCode_17_LetterCombinationsOfAPhoneNumber {
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> res = new LinkedList<>();
            if (digits == null || digits.length() == 0) return res;
            Map<Character, String> map = new HashMap<>();
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
            search("", digits, res, 0, map);
            return res;
        }

        private void search(String s, String digits, List<String> res, int index, Map<Character, String> map) {
            if (index == digits.length()) {
                res.add(s);
                return;
            }
            String lettes = map.get(digits.charAt(index));
            for (int i = 0; i < lettes.length(); i++) {
                search(s + lettes.charAt(i), digits, res, index + 1, map);
            }
        }
    }
}
