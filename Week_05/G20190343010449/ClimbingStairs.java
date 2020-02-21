class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return memo(n);
    }

    public int memo(int n) {
        int[] cache = new int[n + 1];
        cache[1] = 1;
        cache[2] = 2;

        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }
}