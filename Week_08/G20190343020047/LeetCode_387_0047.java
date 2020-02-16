class Solution {
    public int firstUniqChar(String s) {
        int[] character = new int[26];
        for (int i = 0;i < s.length();i++) {
            character[s.charAt(i) - 'a']++;
        }
        for (int i = 0;i < s.length();i++) {
            if (character[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}