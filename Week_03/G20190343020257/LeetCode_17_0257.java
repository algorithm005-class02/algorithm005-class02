class Solution {
    private static final String[] keys = {"", "", "abc", "def", "ghi","jkl",
       "mno", "pqrs", "tuv", "wxyz"};
   public List<String> letterCombinations(String digits) {
       List<String> ret = new LinkedList<>();
       if (null == digits || digits.length() == 0) {
           return ret;        
       }
       combination("", digits, 0, ret);
       return ret;
   }

   public void combination(String str, String digits, int offset, List<String> ret) {
       if (offset >= digits.length()) {
           ret.add(str);
           return;
       }

       String letters = keys[(digits.charAt(offset) - '0')];
       for (int i = 0; i < letters.length(); ++i) {
           combination(str+letters.charAt(i), digits, offset+1, ret);
       }
   }

}