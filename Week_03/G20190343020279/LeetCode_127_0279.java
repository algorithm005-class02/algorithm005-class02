class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        int n = beginWord.length();
        HashMap<String,ArrayList<String>>all_commons = new HashMap<>();
        wordList.forEach(
                word->{
                    for(int i=0; i<n; i++){
                        String common = word.substring(0,i)+"*"+word.substring(i+1);
                        if(!all_commons.containsKey(common))
                            all_commons.put(common, new ArrayList<String>());
                        all_commons.get(common).add(word);
                    }
                }
        );
        HashSet<String> begin = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        HashSet<String> visited = new HashSet<>();
        int len = 1;
        while(!begin.isEmpty() && !end.isEmpty()){
            if(begin.size()>end.size()){
                HashSet<String> tmp = begin;
                begin = end;
                end = tmp;
            }
            HashSet<String> neighbor = new HashSet<>();
            for(String cur : begin){
                for(int i=0; i<n; i++){
                    String tmp = cur.substring(0,i)+"*"+cur.substring(i+1);
                    if(!all_commons.containsKey(tmp))
                        continue;
                    for(String str : all_commons.get(tmp)){
                        if(end.contains(str))
                            return len+1;
                        if(!visited.contains(str)){
                            visited.add(str);
                            neighbor.add(str);
                        }
                    }
                }
            }
            begin = neighbor;
            len++;
        }
        return 0;
    }
}
