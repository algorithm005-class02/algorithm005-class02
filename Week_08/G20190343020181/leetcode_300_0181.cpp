class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if (nums.empty()) return 0;
        vector<int> cnt(nums.size() , 0);
        cnt[0] = 1;
        int res = 0;
        for (int i = 0; i < nums.size(); i++){
            int max_len = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && max_len < cnt[j] + 1) {
                    max_len = cnt[j] + 1;
                }
            }
            cnt[i] = max_len;
            if (max_len > res) res = max_len;
        }
        return res;
    }
};

class Solution2 {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> tails(nums.size(), 0);
        int ret = 0;
        for (auto & num : nums) {
            int i = 0, j = ret;
            while (i < j) {
                int mid = (i + j) >> 1;
                if (tails[mid] < num)
                    i = mid + 1;
                else
                    j = mid;
            }
            tails[i] = num;
            if (j == ret) ret++;
        }
    return ret;
    }
};