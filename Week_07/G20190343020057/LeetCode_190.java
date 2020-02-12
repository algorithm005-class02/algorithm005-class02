public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i =0; i<32;i++){
            res <<= 1;  //每次获取最后1位然后进行移位
            res |= n&1;
            n>>=1;
        }
        return res;
    }
}