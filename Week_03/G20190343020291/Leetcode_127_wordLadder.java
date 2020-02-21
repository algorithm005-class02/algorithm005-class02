import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词接龙
 * https://leetcode.com/problems/word-ladder/
 */
public class Leetcode_127_wordLadder {

    /**
     * 双端BFS 搜索
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int len = 1;

        beginSet.add(beginWord);
        endSet.add(endWord);

        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = new HashSet<>();
                set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> tmpSet = new HashSet<>();
            for (String word : beginSet) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;

                        String newWord = String.valueOf(arr);
                        if (endSet.contains(newWord)) {
                            return len+1;
                        }

                        if (!visited.contains(newWord) && wordSet.contains(newWord)) {
                            visited.add(newWord);
                            tmpSet.add(newWord);
                        }
                    }
                    arr[i] = old;
                }
            }

            beginSet = tmpSet;
            len++;
        }

        return 0;
    }
}
