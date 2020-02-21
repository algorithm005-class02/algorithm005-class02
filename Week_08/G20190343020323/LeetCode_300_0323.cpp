class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        vector<int> dp(nums.size());
        int result = 0;
        dp[0] = nums[0];
        int top = 0;
        for(int i=1;i<nums.size();++i)
        {
            int left = 0;
            int right = top;
            while(left<=right){
                int mid = (left + right) >> 1;
                if(dp[mid] >= nums[i]){
                    right = mid-1;
                }else{
                    left = mid + 1;
                }
            }
            dp[left] = nums[i];
            top = max(top,left);
            result = max(result,left);
        }
        return result+1;
    }
};