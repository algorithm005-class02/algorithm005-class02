class Solution {
public:
    int longestValidParentheses(string s) {
        int res = 0;
        vector<int> dp(s.size(), 0);
        for (int i = 1; i <s.size(); i ++) {
            if (s[i] == ')') {
                if (s[i-1] == '(') {
                    dp[i] = 2 + (i>=2?dp[i-2]:0);
                } else if (i - 1 - dp[i-1] >=0 && s[i - 1 - dp[i-1]] == '(') {
                    dp[i] = 2 + dp[i-1] + (i - 2 - dp[i-1] >= 0?dp[i - 2 - dp[i-1]]:0);
                }
            }
            if (dp[i] > res)
                res = dp[i];
        }
        return res;
    }
};
