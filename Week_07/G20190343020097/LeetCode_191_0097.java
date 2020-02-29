package G20190343020097;

/**
 *  * @author jiangli
 *  * @date 2020/2/27 21:59
 *  * @description
 *  
 */
public class LeetCode_191_0097 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            n = n & (n - 1);
            sum++;
        }
        return sum;
    }

}
