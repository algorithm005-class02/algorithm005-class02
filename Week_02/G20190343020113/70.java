class Solution {
    public int climbStairs(int n) {
        if(n <= 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int c;
        for(int i = 3;i <= n;i++) {
            c = b;
            b = a + b;
            a = c;
        }
        return b;
    }
}