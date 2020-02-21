class Solution {
    private static final HashMap<String, String> letterMap = new HashMap<String, String>(){{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        this.backtrack(digits, 0, "", res);
        return res;
    }

    private void backtrack(String digits, int level, String str, List<String> res) {
        if (level == digits.length()) {
            res.add(str);
            return;
        }

        String letters = letterMap.get(String.valueOf(digits.charAt(level)));
        for (int i = 0; i < letters.length(); i++) {
            this.backtrack(digits, level+1, str + letters.charAt(i), res);
        }
    }
}