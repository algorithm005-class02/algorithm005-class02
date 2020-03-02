package G20190343020095;

/**
 *  * @author jiangli
 *  * @date 2020/2/29 21:06
 *  * @description
 *  
 */
public class LeetCode_709_0097 {

    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) return str;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] += 'a' - 'A';
            }
        }
        return String.valueOf(chars);
    }
}
