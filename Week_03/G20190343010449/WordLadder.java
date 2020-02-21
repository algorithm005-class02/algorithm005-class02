
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();

        HashSet<String> visited = new HashSet<String>();

        ((HashSet) beginSet).add(beginWord);
        ((HashSet) endSet).add(endWord);

        while (!((HashSet) beginSet).isEmpty() && !((HashSet) endSet).isEmpty()) {
            if (((HashSet) beginSet).size() > ((HashSet) endSet).size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }


            Set<String> temp = new HashSet<String>();

            for (String word : beginSet
            ) {
                Char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }
                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;

                    }
                }

            }
            beginSet = temp;
            len++;
        }
        return 0;
    }
}