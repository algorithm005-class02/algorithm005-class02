import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {

    // 库函数解决
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     System.arraycopy(nums2, 0, nums1, m, n);
    //     Arrays.sort(nums1);
    // }

    // 双指针从后往前
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i  = m - 1;
        int j = n - 1;
        int k = n + m - 1;
        while(i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--; 
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        System.arraycopy(nums2, 0, nums1, 0, j + 1); 
    }
}
// @lc code=end

