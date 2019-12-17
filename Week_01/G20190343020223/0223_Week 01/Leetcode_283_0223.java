/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int index=0;
        // int last_index=nums.length-1;
        /* for循环实现：将原先数组中不为0得数值依次覆盖原先得数组空间 */
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0) {
                nums[index]=nums[i];
                index++; //记录数组覆盖之后的下标值，即原先数组中正数的个数
            }
        }
        for (int j=index;j<nums.length;j++){
            nums[j]=0;//将后续数组的空间用0填满
        }
    }
}
// @lc code=end

