package G20190343020097;

/**
 *  * @author jiangli
 *  * @date 2020/2/27 22:13
 *  * @description
 *  
 */
public class LeetCode_190_0097 {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int bitSize = 31; n != 0; n = n >>> 1, bitSize--) {
            ans += (n & 1) << bitSize;
        }
        return ans;
    }
}
