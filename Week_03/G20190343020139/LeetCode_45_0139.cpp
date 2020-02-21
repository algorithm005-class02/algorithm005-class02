/*
 * @lc app=leetcode.cn id=45 lang=cpp
 *
 * [45] 跳跃游戏 II
 *
 * https://leetcode-cn.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (32.83%)
 * Likes:    343
 * Dislikes: 0
 * Total Accepted:    28K
 * Total Submissions: 85.1K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 
 * 示例:
 * 
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 
 * 
 * 说明:
 * 
 * 假设你总是可以到达数组的最后一个位置。
 * 
 */

// @lc code=start
class Solution {
public:
    int jump(vector<int>& nums) {
        int maxpos = 0;
        int end = 0;
        int step = 0;
        for(int i = 0; i < nums.size()-1; i++){
            maxpos = max(maxpos, nums[i]+i);
            if(i==end){
                end = maxpos;
                step ++;
            }
        }
        return step;
    }
    /*
    int jump(vector<int>& nums) {
        queue<pair<int, int>> q;
        q.push({nums[0],0});
        int length;
        int index;
        int level = 0;
        int cur_nums = 1;
        int nxt_nums = 0;
        int cnt = 0;
        while(!q.empty()){
            length = q.front().first;
            index = q.front().second;
            if(index == nums.size()-1) return level;
            q.pop();
            cur_nums --;
            for(int i = 1; i <=length; i++){
                if(index+i < nums.size()){
                    q.push({nums[index+i],index+i});
                    nxt_nums++;
                }
            }
            if(cur_nums == 0){
                level++;
                cur_nums = nxt_nums;
                nxt_nums = 0;
            }
        }
        return level;
    }
    */

};
// @lc code=end

