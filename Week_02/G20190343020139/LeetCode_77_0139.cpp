class Solution {
public:
    vector<vector<int>> res;
    vector<vector<int>> combine(int n, int k) {
        if(n < k || n <= 0 || k <= 0) return res;
        vector<int> nums(n,{(1,n)});
        for(int i = 0; i < n; i ++){
            nums[i] = i+1;
        }
        recurse(nums, k, 0);
        return res;
    }

    void recurse(vector<int>& nums, int k, int start){
        //terminator
        if(nums.size() == k) {
            res.push_back(nums);
            return ;
        }
        //process
        for(int i = start; i < nums.size(); i++){
            vector<int> temp(nums);
            nums.erase(nums.begin()+i);
            //drill down
            recurse(nums,k,i);
            //reverse
            nums = temp;
        }
    }

}