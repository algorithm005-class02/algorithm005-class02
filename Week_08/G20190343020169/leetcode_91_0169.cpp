class Solution {
public:
    int numDecodings(string s) {
        if(s.size() == 0 || s[0] == '0') return 0;
        int pre = 1, curr = 1;
        for(int i = 1; i < s.size(); ++i){
            int temp = curr;
            if(s[i] == '0'){
                 if(s[i - 1] == '1' || s[i - 1] == '2'){
                    curr = pre;
                 }else return 0;
            }else if(s[i - 1] == '1' || (s[i - 1] == '2' && s[i] >= '1' && s[i] <= '6')){
                curr = curr + pre;
            }
            pre = temp;
        }
        return curr;
    }

    int numDecodings1(string s) {
        if(s.size() == 0 || s[0] == '0') return 0;
        if(s.size() == 1) return 1;
        vector<int> dp(s.size(), 0);
        dp[0] = 1;
        if(s[1] == '0' && (s[0] != '1' && s[0] != '2')) {
            return 0;
        }else if(s[0] == '1' || (s[0] == '2' && s[1] >= '0' && s[1] <= '6')){
            dp[1] = (s[1] == '0' ? 0 : 1) + dp[0];
        }else{
            dp[1] = dp[0];
        }
        for(int i = 2; i < s.size(); ++i){
            if(s[i] == '0' && (s[i - 1] != '1' && s[i - 1] != '2')){
                return 0;
            }else if(s[i - 1] == '1' || (s[i - 1] == '2' && s[i] >= '0' && s[i] <= '6')){
                dp[i] = (s[i] == '0' ? 0 : dp[i - 1]) + dp[i - 2];
            }else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.size() - 1];
    }
};
