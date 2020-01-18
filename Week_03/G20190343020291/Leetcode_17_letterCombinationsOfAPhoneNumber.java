import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class Leetcode_17_letterCombinationsOfAPhoneNumber {

    /**
     * 回溯法
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (null == digits || digits.isEmpty()) {
            return res;
        }


        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        helper(digits, 0, "", res, phoneMap);
        return res;
    }


    private void helper(String digits, int level, String path, List<String> res, Map<Character, String> phoneMap) {
        if (level == digits.length()) {
            res.add(path);
            return;
        }

        String letters = phoneMap.get(digits.charAt(level));
        for (int i = 0; i < letters.length(); i++) {
            helper(digits, level + 1, path + letters.charAt(i), res, phoneMap);
        }
    }
}
