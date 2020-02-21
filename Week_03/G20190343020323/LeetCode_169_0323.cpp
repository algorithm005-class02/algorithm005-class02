class Solution {
public:
    int majorityElement(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        int result=nums[0];
        int num = 1;
        for(int i=1;i<nums.size();++i){
            if(nums[i] == result){
                num += 1;
            }else {
                num -= 1;
                if(num == 0){
                    result = nums[i];
                    num = 1;
                }
            }
        }
        return result;
    }
};