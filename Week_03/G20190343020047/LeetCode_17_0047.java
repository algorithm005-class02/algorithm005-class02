class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map = new HashMap<Character,String>(8);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new LinkedList<String>();
        if (digits.length() == 0) {
            return result;
        }
        helper(digits, "", 0, map, result);
        return result;
    }

    public void helper(String digits, String str, int index, Map<Character,String> map,
                       List<String> result) {
        if (index == digits.length()) {
            result.add(str);
            return;
        }
        String letter = map.get(digits.charAt(index));
        for (int i = 0;i<letter.length();++i) {
            helper(digits, str + letter.charAt(i), index + 1, map, result);
        }
    }
}