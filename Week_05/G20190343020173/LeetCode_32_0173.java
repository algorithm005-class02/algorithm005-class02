package org.crayzer.leetcode.editor.en.dynamic_programming;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LeetCode_32_LongestValidParentheses {

    class Solutionn2 {
        public int longestValidParentheses(String s) {
            if (s == null || s.length() == 0) return 0;
            int maxLen = 0;
            int[] dp = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] >= 2) ? dp[i - dp[i - 1] -2] : 0);
                    }
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
            return maxLen;
        }
    }

    /**
     * 对于这种括号匹配问题，一般都是使用栈
     * 我们先找到所有可以匹配的索引号，然后找出最长连续数列！
     * 例如：s = )(()())，我们用栈可以找到，
     * 位置 2 和位置 3 匹配，
     * 位置 4 和位置 5 匹配，
     * 位置 1 和位置 6 匹配，
     * 这个数组为：2,3,4,5,1,6 这是通过栈找到的，我们按递增排序！1,2,3,4,5,6
     * 找出该数组的最长连续数列的长度就是最长有效括号长度！
     * 所以时间复杂度来自排序：O(nlogn)O(nlogn)。
     * 接下来我们思考，是否可以省略排序的过程,在弹栈时候进行操作呢?
     * 直接看代码理解!所以时间复杂度为：O(n)O(n)。
     **/
    class Solution1 {
        public int longestValidParentheses(String s) {
            if (s == null || s.length() == 0) return 0;
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(-1);
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') stack.push(i);
                else {
                    stack.pop();
                    if (stack.isEmpty()) stack.push(i);
                    else res = Math.max(res, i - stack.peek());
                }
            }
            return res;
        }
    }

    // O(n^2)
    class Solution {
        public int longestValidParentheses(String s) {
            int maxLen = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 2; j <= s.length(); j += 2) {
                    if (isValid(s.substring(i, j))) {
                        maxLen = Math.max(maxLen, j - i);
                    }
                }
            }
            return maxLen;
        }

        private boolean isValid(String substring) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < substring.length(); i++) {
                if (substring.charAt(i) == '(') stack.push('(');
                else if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else return false;
            }
            return stack.isEmpty();
        }
    }
}
