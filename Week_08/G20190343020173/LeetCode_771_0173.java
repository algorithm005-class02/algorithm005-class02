package org.crayzer.leetcode.editor.en.string;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_771_JewelsAndStones {
    class Solution1 {
        public int numJewelsInStones(String J, String S) {
            char[] Jc = J.toCharArray();
            char[] Sc = S.toCharArray();
            int result = 0;
            int[] indexMap = new int[150];
            for (int h = 0; h < S.length(); h++) {
                indexMap[Sc[h]] = indexMap[Sc[h]] + 1;
            }
            for (int i = 0; i < J.length(); i++) {
                char a = Jc[i];
                result = result + indexMap[a];
            }
            return result;
        }
    }

    class Solution {
        public int numJewelsInStones(String J, String S) {
            Set<Character> set = new HashSet();
            for (char j : J.toCharArray())
                set.add(j);

            int ans = 0;
            for (char s : S.toCharArray())
                if (set.contains(s))
                    ans++;
            return ans;
        }
    }
}