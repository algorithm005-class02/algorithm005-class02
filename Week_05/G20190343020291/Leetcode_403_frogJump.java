/**
 * 青蛙过河
 * https://leetcode.com/problems/frog-jump/
 */
public class Leetcode_403_frogJump {

    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n + 1];
        dp[0][1] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int dist = stones[i] - stones[j];
                if (dist >= n || !dp[j][dist]) {
                    continue;
                }
                if (dist - 1 >= 0) {
                    dp[i][dist - 1] = true;
                }
                dp[i][dist] = true;
                dp[i][dist + 1] = true;

                if (i == n - 1) {
                    return true;
                }
            }

        }
        return false;
    }
}
