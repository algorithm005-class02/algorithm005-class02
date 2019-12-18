import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    // 数组拷贝法
    // public void rotate(int[] nums, int k) {
    //     if (nums.length == 0) return;
    //     int tmp;
    //     for (int i = 0; i < k; i++) {
    //         tmp = nums[nums.length-1];
    //         System.arraycopy(nums, 0, nums, 1, nums.length - 1);
    //         nums[0] = tmp;
    //     }
    // }
    
    //数组旋转法
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int s, int e) {
        // 数组对调指针重合
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            e--;
            s++;
        }
    }




}
// @lc code=end

