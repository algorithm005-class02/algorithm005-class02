/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 0;  
        for (int i = 1; i < nums.length; i++) {
            if (i > j + 1 && nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            } 
        }
        return j + 1;
    }
}
// @lc code=end

