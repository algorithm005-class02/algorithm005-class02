import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> shortSet = new HashSet<>();
        Set<String> longSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int len = 1;

        shortSet.add(beginWord);
        longSet.add(endWord);
        while (!shortSet.isEmpty() && !longSet.isEmpty()) {

            if (shortSet.size() >= longSet.size()) {
                Set<String> temp = shortSet;
                shortSet = longSet;
                longSet = temp;
            }
            Set<String> tmpSet = new HashSet<>();
            for (String key : shortSet) {
                char[] chars = key.toCharArray();
                for (int j = 0; j < key.length(); j++) {
                    for (char c = 'a'; c < 'z'; c++) {
                        char temp = chars[j];
                        chars[j] = c;
                        String target = String.valueOf(chars);
                        if (longSet.contains(target)) {
                            return len + 1;
                        }
                        if (!visited.contains(target) && wordSet.contains(target)) {
                            tmpSet.add(target);
                            visited.add(target);
                        }
                        chars[j] = temp;
                    }
                }
            }
            shortSet = tmpSet;
            len++;
        }
        return 0;       
    }
}
// @lc code=end

