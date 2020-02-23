import java.util.Stack;

public class LeetCode_0231_032 {

    public static void main(String[] args) {
        String n ="23156";

        int result = new LeetCode_0231_032.Solution().longestValidParentheses(n);

        System.out.println(result);

    }

    /**
     *最长有效括号
     * LeetCode: https://leetcode-cn.com/problems/longest-valid-parentheses
     */
    static class Solution {
        /**
         * 动态规划
         * @param s
         * @return
         */
        public int longestValidParentheses(String s) {
            int maxans = 0;
            int dp[] = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    maxans = Math.max(maxans, dp[i]);
                }
            }
            return maxans;
        }

        /**
         * 栈方法
         * @param s
         * @return
         */
        public int longestValidParentheses_1(String s) {

            int maxans = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.empty()) {
                        stack.push(i);
                    } else {
                        maxans = Math.max(maxans, i - stack.peek());
                    }
                }
            }
            return maxans;
        }
    }

}
