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

    public static void generate(int level, int max, String s) {

        if (level >= max) {
            System.out.println(s);
            return;
        }

        String s1 = s + "(";
        String s2 = s + ")";

        generate(level + 1, max, s1);
        generate(level + 1, max, s2);

    }


    public static List<String> letterCombinations1(String digits) {
        Map<String, String> phone = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};
        List<String> res = new ArrayList<String>();

        helper3("", digits, phone, res, 0);
        if (digits == "") {
            res = new ArrayList<String>();
        }
        return res;
    }

    public static void helper3(String s, String digits, Map<String, String> phone, List<String> res, int i) {
        if (i == digits.length()) {
            res.add(s);
            return;
        }

        String letters = phone.get(digits.charAt(i) + "");
        for (int j = 0; j < letters.length(); j++) {
            helper3(s + letters.charAt(j), digits, phone, res, i + 1);
        }
    }

    public static void main(String[] args) {
        letterCombinations1("23");
    }
}
