import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 * 
 * 思路：
 * 1. 规定不能改变非零元素顺序，那就将0一个个移动至末尾
 * 2. 操作的是数组，不好使用插入或增加的方法，可以使用交换元素位置的方法，复杂度为O(1)
 * 3. 使用交换，需要两个指针，一个在前，一个在后
 * 实现：
 * 1. 前一个指针j找0，为的是将此0替换，所以找到0后在替换之前不能移动。后一个指针i找非0，为的是将非0元素与0元素替换
 * 2. 每次都要移动i，找到非零元素进行替换
 * 
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {

        for (int i = 1, j = 0; i < nums.length;i++) {
            if (nums[i] != 0) {
                if (nums[j]==0) { // 满足j元素为0，执行替换
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;            // 替换后或不满足j元素为0都执行
            }
            else if (nums[j] != 0) j++;

        }
    }
}
// @lc code=end
