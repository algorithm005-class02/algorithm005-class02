package G20190343020095;

/**
 *  * @author jiangli
 *  * @date 2020/2/29 22:36
 *  * @description
 *  
 */
public class LeetCode_344_0097 {

    public void reverseString(char[] s) {
        if (s.length == 0) return;
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }
}
