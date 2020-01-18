/**
 *执行用时 :24 ms, 在所有 cpp 提交中击败了18.53%的用户
 *内存消耗 :9.5 MB, 在所有 cpp 提交中击败了42.33%的用户 
 * 
*/


class Solution {
public:
    vector<vector<int>> res;
    vector<vector<int>> permute(vector<int>& nums) {
        vector<int> track;
        backtrack(nums, track);
        return res;
    }

    void backtrack(vector<int>& nums, vector<int>& track){
        //terminator
        if(track.size() == nums.size()) {
            res.push_back(track);
            return ;
        }
        //process
        for(int i = 0; i < nums.size(); i++){
            int used = 0;
            for(int j = 0; j < track.size(); j ++){
                if(track[j] == nums[i]){
                    used = 1;
                    break;
                }
            }
            if(used) continue;
            track.push_back(nums[i]);
            //drill down
            backtrack(nums, track);
            track.pop_back();
        }
        return;
    }
};