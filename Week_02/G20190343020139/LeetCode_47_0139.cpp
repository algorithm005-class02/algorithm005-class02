/*
 *执行用时 :28 ms, 在所有 cpp 提交中击败了88.95%的用户
 *内存消耗 :10.7 MB, 在所有 cpp 提交中击败了48.29%的用户
*/
class Solution {
public:
    vector<vector<int>> res;
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<int> track;
        backtrack(nums.size(), nums, track);
        return res;
    }

    void backtrack(int size, vector<int>& nums, vector<int>& track){
        //terminator
        if(track.size() == size) {
            res.push_back(track);
            return ;
        }
        //process
        for(int i = 0; i < nums.size(); i++){
            int cut = 0;
            for(int j = 0; j < i ; j++){
                if(nums[i] == nums[j]){
                    cut = 1;
                    break;
                }
            }
            if(!cut){
                track.push_back(nums[i]);
                vector<int> temp(nums);
                nums.erase(nums.begin()+i);
                backtrack(size, nums, track);
                nums = temp;
                track.pop_back();
            }

        }
        return;
    }
};