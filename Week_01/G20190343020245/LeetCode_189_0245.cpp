class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        std::rotate(nums.begin(), nums.end() - k % nums.size(), nums.end());
    }
};
