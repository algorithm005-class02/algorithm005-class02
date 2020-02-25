/**
 * 解码方法
 * https://leetcode.com/problems/decode-ways/
 */
public class Leetcode_91_decodeWays {
    /**
     * 方法1：递归
     */
    public int numDecodings(String s) {
        return helper(s, 0);
    }

    private int helper(String s, int start) {
        if (start == s.length()) {
            return 1;
        } else if (s.charAt(start) == '0') {
            return 0;
        }

        int ans1 = helper(s, start + 1);
        int ans2 = 0;
        if (start < s.length() - 1 && (s.charAt(start) == '1' ||
                (s.charAt(start) == '2' && s.charAt(start + 1) < '7'))) {
            ans2 = helper(s, start + 2);
        }

        return ans1 + ans2;
    }

    /**
     * 方法2：递归+记忆化搜索
     */
    public int numDecodings2(String s) {
        return helper(s, 0, new int[s.length() + 1]);
    }

    private int helper(String s, int start, int[] memo) {
        if (start == s.length()) {
            return 1;
        } else if (s.charAt(start) == '0') {
            return 0;
        }

        int ans1 = 0;
        if (memo[start + 1] != 0) {
            ans1 = memo[start + 1];
        } else {
            ans1 = helper(s, start + 1, memo);
            memo[start + 1] = ans1;
        }

        int ans2 = 0;
        if (start < s.length() - 1 && (s.charAt(start) == '1' ||
                (s.charAt(start) == '2' && s.charAt(start + 1) < '7'))) {
            if (memo[start + 2] != 0) {
                ans2 = memo[start + 2];
            } else {
                ans2 = helper(s, start + 2, memo);
                memo[start + 2] = ans2;
            }
        }
        return ans1 + ans2;
    }
    /**
     * 方法3：DP
     */
    public int numDecodings3(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] += dp[i + 1];
                if (i < n - 1 && (s.charAt(i) == '1' ||
                        (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return n == 0 ? 0 : dp[0];
    }
    /**
     * 方法4： DP 状态数组优化
     */
    public int numDecodings4(String s) {
        int n = s.length();
        int prev = 1, pprev = 0;
        for (int i = n - 1; i >= 0; i--) {
            int cur = 0;
            if (s.charAt(i) != '0') {
                cur += prev;
                if (i < n - 1 && (s.charAt(i) == '1' ||
                        (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
                    cur += pprev;
                }
            }
            pprev = prev;
            prev = cur;
        }
        return prev;
    }
}
