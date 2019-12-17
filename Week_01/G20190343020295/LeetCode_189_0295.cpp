class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int len = nums.size();
        if (len <= 1)   // 空数组和只有一个元素的数组直接返回
            return;
        int kk = k % len;   // 这里向右移动具有周期性，周期为nums.size()
        reverse(nums.begin(), nums.end());
        reverse(nums.begin(), nums.begin() + kk);
        reverse(nums.begin() + kk, nums.end());
    }
};