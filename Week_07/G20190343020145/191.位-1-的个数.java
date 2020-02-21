//方法1，位运算循环遍历，时间和空间复杂度均为O(1)
/*
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bits = 0;
        //定义掩码
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                //掩码与后为1时，计数+ 1
                bits++;
            }
            //掩码左移1位
            mask <<= 1;
        }
        return bits;
    }
}
*/

//方法2，位运算优化，时间和空间复杂度均为O(1)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       int count = 0;
       while(n!=0){
           //每次与n-1循环与，清除最后二进制一位1，然后计数
           n &= n-1;
           count ++;
       }
       return count;
    }
}