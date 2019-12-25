public class LeetCode_70_0299 {

    public static void main(String[] args) {
        LeetCode_70_0299 leetCode = new LeetCode_70_0299();
        int res = leetCode.climbStairs(4);
        System.out.println(res);
    }

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climb_stairs(0, n, memo);
    }

    private int climb_stairs(int i, int n, int[] memo) {
        if (i > n)
            return 0;
        if (i == n)
            return 1;
        // 爬到第i阶 台阶不同的方法数 缓存
        if (memo[i] > 0)
            return memo[i];

        memo[i] = climb_stairs(i + 1, n, memo) + climb_stairs(i + 2, n, memo);
        return memo[i];
    }
}
