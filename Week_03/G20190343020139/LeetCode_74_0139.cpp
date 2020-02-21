/*
 * @lc app=leetcode.cn id=74 lang=cpp
 *
 * [74] 搜索二维矩阵
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (37.03%)
 * Likes:    121
 * Dislikes: 0
 * Total Accepted:    29.1K
 * Total Submissions: 78.4K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 
 * 
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int row = matrix.size();
        if(row == 0) return false;
        int col = matrix[0].size();
        if(col == 0) return false;
        cout<<"row:"<<row<<"col:"<<col<<endl;
        for(int i = 0; i < row; i ++){
            if(target <= matrix[i][col-1]){
                cout<<matrix[i][col-1]<<endl;
                return bisearch(matrix, i, col, target);
            }
        }
        return false;
    }
    bool bisearch(vector<vector<int>>& matrix, int row, int col, int target){
        int left = 0;
        int right = col-1;
        int middle;
        cout<<"left:"<<left<<" right:"<<right<<endl;
        while(left < right){
            middle = left + (right - left)/2;
            if(matrix[row][middle] == target) return true;
            else if(matrix[row][middle] > target) right = middle - 1;
            else if(matrix[row][middle] < target) left = middle + 1;
        }
        if(left == right && matrix[row][left] == target) return true;
        else return false;
    }
};
// @lc code=end

