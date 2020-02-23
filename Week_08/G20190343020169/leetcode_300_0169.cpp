class Solution {
public:

    int lengthOfLIS(vector<int>& nums) {
        if(nums.size() <= 0) return 0;
        vector<int> tails(nums.size(),0);
        int res = 0;
        for(auto num : nums){
             int i = 0;
             int j = res;
             int m = 0;
             while(i < j){
                 m = (i + j) >> 1;
                 if(tails[m] < num) i = m + 1;
                 else if(tails[m] >= num) j = m;
             }
             tails[i] = num;
             if(j == res) res++;
        }
        return res;
    }

    int lengthOfLIS1(vector<int>& nums) {
        if(nums.size() <= 0) return 0;
        vector<int> dp(nums.size(),1);
        int max = 0;
        for(int i = 0; i < nums.size(); ++i){
            for(int j = 0; j <= i; ++j){
                if(nums[i] > nums[j]) dp[i] = std::max(dp[i], dp[j] + 1);
            }
            max = std::max(dp[i],max);
        }
        return max;
    }

};
