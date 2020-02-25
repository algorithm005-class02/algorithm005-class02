/**
 * 位1的个数
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class Leetcode_191_numberOf1bits {
    /**
     * 方法1：逐位检查
     */
    public int hammingWeight(int n) {
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                res++;
            }
            mask <<= 1;
        }
        return res;
    }

    /**
     * 方法2：清零最低位的1
     */
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res ++;
        }
        return res;
    }

}
