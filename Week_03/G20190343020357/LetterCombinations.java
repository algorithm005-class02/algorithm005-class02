package com.divider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        Map<String, String> map = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};
        List<String> output = new ArrayList<String>();
        backTrack("", digits, output, 0, map);
        return output;
    }

    public void backTrack(String combination, String digits, List<String> output, int level, Map<String, String> map) {
        if (level == digits.length()) {
            output.add(combination);
            return;
        }

        String letters = map.get(digits.charAt(level));

        for (int i = 0; i < letters.length(); i++) {
            backTrack(combination + letters.charAt(i), digits, output, level + 1, map);
        }
    }
}
