/**
 * 颠倒二进制位
 * https://leetcode.com/problems/reverse-bits/
 */
public class Leetcode_190_reverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res |= (n >> (31 - i) & 1) << i;
        }
        return res;
    }
}
