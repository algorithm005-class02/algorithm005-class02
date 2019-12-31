class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) {
            return new ArrayList<>(0);
        }
        String[][] map = new String[][] {
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}
        };
        
        List<String> res = new ArrayList<>();
        for (String str : map[Integer.parseInt(digits.charAt(0) + "") - 2]) {
            process(res, map, str, digits, 1);
        }
        return res;
    }
    
    private void process(List<String> res, String[][] map, String str, String digits, int index) {
        if (index == digits.length()) {
            res.add(str);
            return;
        }
        for (String s : map[Integer.parseInt(digits.charAt(index) + "") - 2]) {
            process(res, map, str + s, digits, index + 1);
        }
    }
}