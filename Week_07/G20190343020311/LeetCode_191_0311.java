public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // int bits = 0, mask = 1;
        // for (int i = 0; i < 32; i++) {
        //     if ((n & mask) != 0) {
        //         bits++;
        //     }
        //     mask <<= 1;
        // }
        // return bits;
        int num = 0;
        while (n != 0) {
            num++;
            n &= (n - 1);
        }
        return num;
    }
}