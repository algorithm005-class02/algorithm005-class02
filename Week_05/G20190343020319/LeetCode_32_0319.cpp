class Solution {

public:
    int longestValidParentheses(string s) {
        if(s.length() < 2) {
            return 0;
        }
        int longestValid = 0;
        vector<int> dp( s.length(), 0);
        if('(' ==  s.at(0) && ')' ==  s.at(1)) {
            dp[1] = 2;
            longestValid = 2;
            
        }
        for(int i = 2; i < s.length(); i++) {
            if(')' != s.at(i)) {
                continue;
            }
            if('(' == s.at(i - 1)) {
                dp[i] = dp[i - 2] + 2;
                longestValid = max(dp[i], longestValid);
            } 
            else if((i - dp[i - 1] - 1) >= 0 && '(' == s.at(i - dp[i - 1] - 1)) {
                if((i - dp[i - 1] -2) >= 0) {
                    dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] -2];
                }
                else {
                    dp[i] = dp[i - 1] + 2;
                }
                
                longestValid = max(dp[i], longestValid);
            }
        }  
        return longestValid;
    }
};