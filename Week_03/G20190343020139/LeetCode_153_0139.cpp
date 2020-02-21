/*
 * @lc app=leetcode.cn id=153 lang=cpp
 *
 * [153] 寻找旋转排序数组中的最小值
 *
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (50.13%)
 * Likes:    133
 * Dislikes: 0
 * Total Accepted:    29.3K
 * Total Submissions: 58.4K
 * Testcase Example:  '[3,4,5,1,2]'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7]  可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 请找出其中最小的元素。
 * 
 * 你可以假设数组中不存在重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 
 * 示例 2:
 * 
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * 
 */

// @lc code=start
class Solution {
public:
    int findMin(vector<int>& nums) {
        if(nums.back()>nums[0]) return nums[0];
        int left = 0;
        int right = nums.size()-1;
        int middle;
        while(left < right){
            middle = left + (right - left)/2;
            if(nums[0] <= nums[middle]) {
                left = middle + 1;
            }
            else right = middle;
            cout << "left:"<<left<< " right:"<<right<<endl;
        }
        return nums[right];

        
    }
};
// @lc code=end

