/*
 * @lc app=leetcode.cn id=120 lang=cpp
 *
 * [120] 三角形最小路径和
 *
 * https://leetcode-cn.com/problems/triangle/description/
 *
 * algorithms
 * Medium (63.27%)
 * Likes:    295
 * Dislikes: 0
 * Total Accepted:    37.1K
 * Total Submissions: 58.5K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 
 * 例如，给定三角形：
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 
 * 说明：
 * 
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * 
 */

// @lc code=start
class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
    //重复性
    //DP数组
    //递推方程：f(x,y) = min(f(x+1,y), f(x+1, y+1)) + f(x,y)   
    /*
        for(int i = triangle.size()-2; i >= 0; i--){
            for(int j = triangle[i].size()-1; j >= 0; j--){
                //cout<<"dp["<<i<<"]["<<j<<"]："<<dp[i][j]<<endl;
                triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }
        return triangle[0][0];
    */
    int dp[triangle[triangle.size()-1].size()];
    for(int j = 0; j < triangle[triangle.size()-1].size(); j++){
        dp[j] = triangle[triangle.size()-1][j];
    }
    for(int i = triangle.size()-2; i >= 0; i--){
            for(int j = 0; j < triangle[i].size(); j++){
                dp[j] = min(dp[j], dp[j+1]) + triangle[i][j];
            }
        }
        return dp[0];
    }
};
// @lc code=end

