class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        // for(int i=0;i<nums.size()-1;++i)   
        //     for(int j=i+1;j<nums.size();++j){
        //         if(target == nums[i] + nums[j]){
        //             return vector<int>{i,j};
        //         }
        //     }
        // return vector<int>();
        unordered_map<int,int> hash;
        for(int i=0;i<nums.size();++i){
            int temp = target - nums[i];
            if(hash.find(temp) != hash.end()){
                return {hash[temp],i};
            }
            hash[nums[i]] = i;
        }
        return {};
    }
};