class Solution {
public:
    //哈希表
    // int majorityElement(vector<int>& nums) {
    //    unordered_map<int, int> myMap;
    //    for (int i = 0; i < nums.size(); i++) {
    //        myMap[nums[i]]++;
    //        if (myMap[nums[i]] > nums.size()/2)
    //            return nums[i];
    //    }
    //    return -1;
    //}
    //排序
    // int majorityElement(vector<int>& nums) {
    //    sort(nums.begin(), nums.end());
    //    return nums[nums.size()/2];
    //}
    // moore voting //excellent
    int majorityElement(vector<int>& nums) {
        int counter = 0, majority;
        for (int num : nums) {
            if (!counter) {
                majority = num;
            }
            counter += num == majority ? 1 : -1;
        }
        return majority;
    }
    //分治 divide & conquer
    int majorityElement2(vector<int>& nums) {
        return majorityElementDC(nums, 0, nums.size() - 1);
    }

private:
    int majorityElementDC(vector<int>& nums, int startIndex, int endIndex) {
        // terminator
        if (startIndex == endIndex) return nums[startIndex];

        int midIndex = (endIndex + startIndex) / 2;
        int leftMajor = majorityElementDC(nums, startIndex, midIndex);
        int rightMajor = majorityElementDC(nums, midIndex + 1, endIndex);
        if (leftMajor == rightMajor) {
            return leftMajor;
        }
        return count(nums.begin() + startIndex, nums.begin() + endIndex + 1,
                     leftMajor) > count(nums.begin() + startIndex,
                                        nums.begin() + endIndex + 1, rightMajor)
                   ? leftMajor
                   : rightMajor;
    }
};