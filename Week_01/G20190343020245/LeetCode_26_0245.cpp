class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        auto iter=unique(nums.begin(),nums.end());      //重排容器
        //nums.erase(iter,nums.end());    //删除重复元素
        return iter-nums.begin();     
    }
};