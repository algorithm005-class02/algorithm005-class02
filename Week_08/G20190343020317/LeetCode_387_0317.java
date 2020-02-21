class Solution {
    public int firstUniqChar(String s) {
        int [] chars = new int[26];
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            chars[s.charAt(i)-'a']++;
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (chars[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}