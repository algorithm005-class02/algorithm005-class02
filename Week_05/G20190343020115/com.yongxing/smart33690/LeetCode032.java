package smart33690;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class LeetCode032 {
    public static void main(String[] args) {
        LeetCode032 instance = new LeetCode032();
        String s = "(()";
        int res = instance.longestValidParentheses(s);
            System.out.println(res);
    }
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



}
