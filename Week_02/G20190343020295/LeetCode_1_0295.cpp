class Solution {
public:
    // 一遍哈希
    // 时间复杂度 O(N)
    // 空间复杂度 O(N)
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> myMap;
        vector<int> myRes;
        for (int i = 0; i < nums.size(); i++) {
			// 在将当前数字放入哈希表之前，检查当前哈希表中是否存在目标值
			// 哈希表的查找 O(1)
            if (myMap.find(target - nums[i]) != myMap.end()) {
                myRes.push_back(myMap[target - nums[i]]);
                myRes.push_back(i);
                return myRes; 
            }
            myMap[nums[i]] = i;	
        }
        return myRes;
    }
};