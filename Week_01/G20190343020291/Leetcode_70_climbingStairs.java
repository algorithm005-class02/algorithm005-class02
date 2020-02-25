/**
 * 爬楼梯
 * https://leetcode.com/problems/climbing-stairs/
 */
class Leetcode_70_climbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
