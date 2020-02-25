package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * * @author jiangli
 * * @date 2019/12/25 16:50
 * * @description letter-combinations-of-a-phone-number 电话号码的字母组合
 */
public class LeetCode_17_0097 {


    /**
     * 递归
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        String[] characters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] phones = digits.toCharArray();
        List<String> result = new ArrayList<>();
        recurse(phones, 0, "", result, characters);
        return result;
    }

    public void recurse(char[] digits, int index, String preComb, List<String> res, String[] characters) {
        //recursion terminator
        if (index == digits.length) {
            res.add(preComb);
        } else {
            //process logic in current level
            //drill down
            String letter = characters[Character.getNumericValue(digits[index])];
            char[] letterChars = letter.toCharArray();
            for (int i = 0; i < letterChars.length; i++) {
                recurse(digits, index, preComb + letterChars[i], res, characters);
            }
            //revert state
            index++;
        }
    }
}
