class Solution {
    public int firstUniqChar(String s) {
        int[] mp = new int[26];
        char[] ca = s.toCharArray();
        for (int i = 0;i < s.length();i++) {
            mp[ca[i] - 'a']++;
        }
        for (int i = 0;i < s.length();i++) {
            if (mp[ca[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}