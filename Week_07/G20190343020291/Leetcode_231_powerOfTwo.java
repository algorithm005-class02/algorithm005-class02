/**
 * 2的幂
 * https://leetcode.com/problems/power-of-two/
 */
public class Leetcode_231_powerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
