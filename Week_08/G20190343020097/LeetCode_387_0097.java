package G20190343020095;

import java.util.HashMap;

/**
 *  * @author jiangli
 *  * @date 2020/2/29 21:40
 *  * @description
 *  
 */
public class LeetCode_387_0097 {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            Integer count = map.get(c);
            count = count == null ? 1 : count++;
            map.put(c, count);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
