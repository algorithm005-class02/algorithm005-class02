
// 循环32次，依次统计所在位为1的个数。通过一个特殊的每次左移一位的数来做按位与。
public class Solution {

    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            // ！=0 ，则所在位为1
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}
