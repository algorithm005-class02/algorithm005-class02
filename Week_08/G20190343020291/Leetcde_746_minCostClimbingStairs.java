/**
 * 使用最小花费爬楼梯
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class Leetcde_746_minCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }
}
