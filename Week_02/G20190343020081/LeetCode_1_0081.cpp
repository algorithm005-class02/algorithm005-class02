class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> record;
        for(int i=0; i<nums.size(); i++) {
            int tmp = target - nums[i];
            if(record.find(tmp) != record.end()) {
                int ret[] = {record[tmp], i}; 
                return vector<int>(ret, ret+2);
            }
            record[nums[i]] = i; 
        }
        throw invalid_argument("the input has no solution");
    }
};

