package G20190343020095;

import java.util.ArrayList;
import java.util.List;

/**
 *  * @author jiangli
 *  * @date 2020/2/29 22:27
 *  * @description
 *  
 */
public class LeetCode_14_0097 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return null;
        List<char[]> chars = new ArrayList<>();
        for (String str : strs) {
            chars.add(str.toCharArray());
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
