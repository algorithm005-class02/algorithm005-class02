// 数要是2的幂次方，则其二进制表示只有一个1。那么通过x&（x-1）是否等于0来判断。
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }
}
