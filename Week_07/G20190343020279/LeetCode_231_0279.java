class Solution {
    public boolean isPowerOfTwo(int n) {
        long x = (long) n;
        return n != 0 && (x & x - 1) == 0;
    }
}