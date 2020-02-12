//2的幂次方问题转化为，二进制数中仅有一个1，即清零操作只需一次
/*
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        if((n&(n - 1)) == 0)
            return true;
        return false;
        
    }
}
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n &(n - 1)) == 0;
    }
}