class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        char [] sArr = s.toCharArray();
        char [] tArr = t.toCharArray();
        int len = sArr.length;
        Map<Character, Integer> letterMap = new HashMap<>();
        for(int i = 0; i<len; i++){
            if(letterMap.containsKey(sArr[i])){
                letterMap.put(sArr[i], letterMap.get(sArr[i])+1);
            }else {
                letterMap.put(sArr[i], 1);
            }
        }

        for(int i = 0; i<len; i++){
            if(letterMap.containsKey(tArr[i])){
                if(letterMap.get(tArr[i])<0){
                    return false;
                }
                letterMap.put(tArr[i], letterMap.get(tArr[i])-1);
            }else {
                letterMap.put(tArr[i], -1);
            }
        }

        for(char x: letterMap.keySet()){
            if (letterMap.get(x)!=0){
                return false;
            }
        }
        return true;
    }

    /**
    * 没有hashtable参与，字母总共只有26个
    **/
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        int [] arr = new int[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int len = s.length();
        for(int i = 0; i<len; i++){
            arr[sArr[i]-'a']++;
        }
        for(int i = 0; i<len; i++){
            if( arr[tArr[i]-'a']<0){
                return false;
            }
            arr[tArr[i]-'a']--;
        }
        for(int i = 0; i<26;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
}