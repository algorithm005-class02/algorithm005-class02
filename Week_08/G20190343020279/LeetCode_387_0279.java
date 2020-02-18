class Solution {
    public int firstUniqChar(String s) {
              int only[] = new int[26];
        for(int i = 0; i < s.length(); i++){
            only[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            if(only[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1; 
    }
}