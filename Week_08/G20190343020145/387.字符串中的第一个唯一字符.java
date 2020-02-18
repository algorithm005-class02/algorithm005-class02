//hashmap
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char ch:s.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0) + 1); 
        }
        for(char ch:s.toCharArray()){
            if(hm.get(ch) == 1){
                return s.indexOf(ch);
            }
        }
        return -1;
        
    }
}


//一维数组统计出现字母频次，取第一个计数为1的字母索引。
/*
class Solution {
    public int firstUniqChar(String s) {
        int[] alphabet = new int[26];
        for(char ch:s.toCharArray()){
            alphabet[ch - 'a'] ++;
        }
        for(char ch:s.toCharArray()){
            if(alphabet[ch - 'a'] == 1) 
                return s.indexOf(ch);
        }
        return -1;
    }
}
*/