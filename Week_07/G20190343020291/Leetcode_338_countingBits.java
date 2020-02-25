/**
 * 比特位计数
 * https://leetcode.com/problems/counting-bits/
 */
public class Leetcode_338_countingBits {
    /**
     * 方法1：
     */

    /**
     * 方法2：位运算
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + i % 2;
        }
        return res;
    }
}
