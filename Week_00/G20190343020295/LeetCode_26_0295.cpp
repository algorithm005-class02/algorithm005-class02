class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (0 == nums.size()) {return 0;}
        int offsetIndex = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i - 1] == nums[i]) {offsetIndex++;}
            if (offsetIndex > 0) {nums[i - offsetIndex] = nums[i];}
        }
        return nums.size() - offsetIndex;
    }
};
