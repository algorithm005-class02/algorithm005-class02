package G20190343020095;

import java.util.HashSet;
import java.util.Set;

/**
 *  * @author jiangli
 *  * @date 2020/2/29 21:33
 *  * @description
 *  
 */
public class LeetCode_771_0097 {

    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) return 0;
        char[] chars = J.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            set.add(c);
        }
        char[] sChars = S.toCharArray();
        int count = 0;
        for (char c : sChars) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
