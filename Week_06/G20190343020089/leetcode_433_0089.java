import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) return -1;
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int res = 0;
        startSet.add(start);
        endSet.add(end);
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            if (startSet.size() >= endSet.size()) {
                Set<String> set = startSet;
                startSet = endSet;
                endSet = set;
            }
            Set<String> tempSet = new HashSet<>();
            for (String str : startSet) {
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                    char curChar = chars[i];
                    for (char c = 'A'; c < 'Z'; c++) {
                        chars[i] = c;
                        String target = String.valueOf(chars);
                        if (endSet.contains(target)) return res + 1;
                        if (bankSet.contains(target) && !visited.contains(target)) {
                            tempSet.add(target);
                            visited.add(target);
                        }
                    }
                    chars[i] = curChar;
                }
            }
            startSet = tempSet;
            res++;
        }
        return -1;
    }
}
// @lc code=end

