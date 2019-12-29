import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 * 
 * 根据题意：修改nums1来实现目的，而且nums1长度大于m+n
 * 1. 将nums2的元素复制到nums1的m-->(m+n)位置,再给nums排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
 * 2. 双指针：空间换时间，先copy一个nums1数组，依次比较nums2和copy_nums1中的元素，
 *      然后将小的一方从0开始存入nums1，存完后指针+1；
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while ((p1 < m) && (p2 < n)) {
            //可以三目运算简化代码 nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
            if (nums1_copy[p1] <nums2[p2]) {
                nums1[p] = nums1_copy[p1++];
            } else {
                nums1[p] = nums2[p2++];
            }
            p++;
        }
        if (p1 < m) System.arraycopy(nums1_copy, p1, nums1, p, m + n - p);
        if (p2 < n) System.arraycopy(nums2, p2, nums1, p, m + n - p);
    }

}
// @lc code=end
