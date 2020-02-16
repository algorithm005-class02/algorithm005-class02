package leetcode.week08;

import java.util.Stack;

public class LeetCode_32_0069 {
    private static int longestValidParentheses (String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans , i - stack.peek());
                }
            }

        }
        return maxans;
    }

    private static int longestValidParenthesesByDp (String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) +2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }

        return maxans;
    }

    public static void main (String args[]) {
        String s = "(()";
        System.out.println(longestValidParenthesesByDp(s));
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//
//        System.out.println("pop "+stack.pop());
//        System.out.println("peek "+stack.peek());
    }

}
