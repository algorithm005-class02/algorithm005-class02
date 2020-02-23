class Solution {
    public int firstUniqChar(String s) {
        for(char temp : s.toCharArray()){
            if(s.lastIndexOf(temp) == s.indexOf(temp))
                return s.indexOf(temp);
        }
        return -1;
    }
}