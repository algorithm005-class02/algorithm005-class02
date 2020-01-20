class Solution {
     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList();
        int len = wordList.size(), ans = 0;
        Set<String> set = new HashSet();
        set.add(beginWord);
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            ans ++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String str = queue.poll();
                if(str.equals(endWord)) return ans;
                for(String val : wordList){
                    if(!set.contains(val) && check(val, str)){
                        set.add(val);
                        queue.offer(val);
                    }
                }  
            }
        }
        return 0;
    }
    private boolean check(String a, String b){
        int res = 0;
        for(int i = 0; i  a.length(); i++)
            if(a.charAt(i) != b.charAt(i)) res ++;
        return res == 1;
    }
}