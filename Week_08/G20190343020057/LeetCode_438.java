class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        int[] smap = new int[26];//类似哈希表，保存字母次数
        int[] pmap = new int[26];
        for(int i=0;i<p.length();i++){
            pmap[p.charAt(i)-'a']++;
        }
        int valid = 0; //保存已发现所有待发现字母
        while(right < s.length()){//先移动右指针，来符合条件
            char st = s.charAt(right);
            if(pmap[st-'a'] > 0){
                smap[st-'a']++;
                if(smap[st-'a'] <= pmap[st-'a']){
                    valid++;
                }
            }

            while(valid==p.length()){//再移动左指针，做滑动窗口
                if(right-left+1 == p.length()){
                        res.add(left);
                }
                char lt = s.charAt(left);
                if(pmap[lt-'a'] > 0){
                    smap[lt-'a']--;
                    if(smap[lt-'a'] < pmap[lt-'a']){
                        valid--;
                    }
                    
                }
                left++;
            }
            right++;
        }
        return res;
    }
}