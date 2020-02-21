import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return new String(sChars).equals(new String(tChars));
        // int[] table = new int[26];
        // for (int i = 0; i < s.length(); i++) {
        //     table[(int) s.charAt(i) - 'a']++;
        //     table[(int) t.charAt(i) - 'a']--;
        // }

        // for (int i = 0; i < 26; i++) {
        //     if (table[i] != 0) {
        //         return false;
        //     }
        // }
        // return true;  
    }
}
// @lc code=end

