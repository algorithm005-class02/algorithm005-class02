package G20190343020097;

/**
 *  * @author jiangli
 *  * @date 2020/2/27 22:06
 *  * @description
 *  
 */
public class LeetCode_231_0097 {

    public boolean isPowerOfTwo(int n) {
        return n != 0 && ((n & (n - 1)) == 0);
    }
}
