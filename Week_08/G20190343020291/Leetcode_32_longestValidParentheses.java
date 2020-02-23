/**
 * 最长有效括号
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class Leetcode_32_longestValidParentheses {

    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int ret = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    if (i - dp[i - 1] >= 1 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                }
                ret = Math.max(ret, dp[i]);
            }
        }
        return ret;
    }


}
