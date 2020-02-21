class Solution {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        combination("", digits, 0, res);
        return res;
    }


    /**
     * @param prefix 当前拼接的字符串前缀
     * @param digits 数字字符串
     * @param offSet 数字字符串当前下探到的位置
     * @param res 返回结果
     */
    public void combination(String prefix, String digits, int offSet, List<String> res) {
        //1.recursion terminator
        if (offSet >= digits.length()) {
            res.add(prefix);
            return;
        }
        //2.prepare the current level status(digits.length and offSet)
        String letter = KEYS[digits.charAt(offSet) - '0'];
        //3.process the current level logic
        for (int i = 0; i < letter.length(); i++) {
            combination(prefix + letter.charAt(i), digits, offSet + 1, res);
        }
        //4.revert the result if needed
    }
}