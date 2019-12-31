class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int count = 1;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        Set<String> visited = new HashSet<>();
        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> replace = beginSet;
                beginSet = endSet;
                endSet = replace;
            }
            
            Set<String> temp = new HashSet<>();
            for (String str : beginSet) {
                char[] ca = str.toCharArray();
                for (int i = 0;i < ca.length;i++) {
                    for (char c = 'a';c <= 'z';c++) {
                        char oldc = ca[i];
                        ca[i] = c;
                        String newStr = String.valueOf(ca);
                        if (endSet.contains(newStr)) {
                            return count + 1;
                        }
                        if (!visited.contains(newStr) && wordList.contains(newStr)) {
                            visited.add(newStr);
                            temp.add(newStr);
                        }
                        ca[i] = oldc;
                    }
                }
            }
            beginSet = temp;
            count++;
        }
        return 0;
    }
}