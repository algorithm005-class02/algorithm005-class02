// hash表
class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        HashSet<Character> Jset = new HashSet<>();
        for(char j:J.toCharArray()){
            Jset.add(j);
        }
        for(char s:S.toCharArray()){
            if(Jset.contains(s)){
                count ++;
            }
        }
        return count;
    }
}

//HashMap 解3 - getOrDefault优化版
/*
class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        HashMap<Character,Integer> smap = new HashMap<>();
        for(int i = 0; i < S.length(); ++ i){
            char s = S.charAt(i);
            smap.put(s,smap.getOrDefault(s, 0) + 1);
        }
        for(int i = 0;i < J.length() ; ++ i){
            char j = J.charAt(i);
            if(smap.containsKey(j)){
                count += smap.get(j);
            }
        }
        return count;
    }
}
*/


/*暴力法1
class Solution {
    public int numJewelsInStones(String J, String S) {
        int reslut = 0;
        for(char j:J.toCharArray()){
            for(char s:S.toCharArray()){
                if(j == s){
                    reslut ++;
                }
            }
        }
        return reslut;


    }
*/

/*暴力法2
class Solution {
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        for (char s: S.toCharArray()) // For each stone...
            for (char j: J.toCharArray()) // For each jewel...
                if (j == s) {  // If the stone is a jewel...
                    ans++;
                    break; // Stop searching whether this stone 's' is a jewel
                }
        return ans;
    }
}
*/

/* HashMap解1-自己-转化成Char的HashMap
class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        HashMap<Character,Integer> SS = new HashMap<>();
        for(int i = 0; i < S.length(); ++ i){
            if(SS.containsKey(S.charAt(i))){
                SS.put(S.charAt(i),SS.get(S.charAt(i)) + 1);
                continue;
            }
            SS.put(S.charAt(i),1);
        }
        for(int i = 0;i < J.length() ; ++ i){
            if(SS.containsKey(J.charAt(i))){
                count += SS.get(J.charAt(i));
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Solution js = new Solution();
        System.out.println(js.numJewelsInStones("aA","aAAbbbb"));
    }
}
*/


/* HashMap 解2 - 自己优化版
class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        HashMap<Character,Integer> smap = new HashMap<>();
        for(int i = 0; i < S.length(); ++ i){
            char s = S.charAt(i);
            if(smap.get(s) == null){
                smap.put(s, 1);
            }else{
                smap.put(s, smap.get(s) + 1);
            }
        }
        for(int i = 0;i < J.length() ; ++ i){
            char j = J.charAt(i);
            if(smap.containsKey(j)){
                count += smap.get(j);
            }
        }
        return count;
    }
}
*/


//String 的HashMap
/*
class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        HashMap<String,Integer> smap = new HashMap<>();
        for(int i = 0; i < S.length(); ++ i){
            String s = S.substring(i, i + 1);
            if(smap.get(s) == null) smap.put(s, 1);
            else smap.put(s, smap.get(s) + 1);
        }
        for(int i = 0; i < J.length(); ++ i){
            String j = J.substring(i, i + 1);
            if(smap.containsKey(j)){
                count += smap.get(j);
            }
        }
        return count;
    }
}
*/


