public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        int count = 0;

        while (count < 32) {
            res <<= 1;//先左移
            res += (n & 1);//加上n最后一位
            n >>= 1;//n右移
            count++;
        }

        return res;
    }

}