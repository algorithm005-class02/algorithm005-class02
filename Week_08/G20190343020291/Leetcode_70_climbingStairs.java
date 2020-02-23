import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 爬楼梯 及其扩展问题
 * https://leetcode.com/problems/climbing-stairs/
 */
public class Leetcode_70_climbingStairs {
    /**
     * 1. 每次爬1级或2级
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 2. 每次爬1级、2级或3级
     */
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    /**
     * 3. 每次爬的台阶级数定义在一个数组中
     */
    public int climbStairs3(int n, int[] steps) {
        if (n == 1) {
            return 1;
        }
        Arrays.sort(steps);
        int max = Math.max(steps[steps.length - 1], n);
        int[] dp = new int[max + 1];
        for (int step : steps) {
            dp[step] = 1;
        }

        for (int i = steps[0]; i <= n; i++) {
            int j = 0;
            while (j < steps.length && steps[j] < i) {
                dp[i] += dp[i - steps[j]];
                j++;
            }
        }
        return dp[n];
    }

    /**
     * 4. 每次可以爬1级、2级、3级、且相邻的步数不同
     */
    public int climbStairs4(int n) {
        if (n == 1) {
            return 1;
        }

        int[][] dp = new int[n + 1][4];
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;
        dp[2][1] = 0;
        dp[2][2] = 1;
        dp[2][3] = 0;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= 3; j++) {
                dp[i][j] = dp[i - j][1]  + dp[i -j][2] + dp[i - j][3] - dp[i - j][j];
            }
        }
        return dp[n][1] + dp[n][2] + dp[n][3];
    }


    public static void main(String[] args) {
        Leetcode_70_climbingStairs solution = new Leetcode_70_climbingStairs();
//        System.out.println(solution.climbStairs(5));
//        System.out.println(solution.climbStairs2(20));
//        System.out.println(solution.climbStairs3(20, new int[]{1, 2, 3}));
//        System.out.println(solution.climbStairs3(6, new int[]{1, 3, 5}));
        System.out.println(solution.climbStairs4(5));
    }
}
