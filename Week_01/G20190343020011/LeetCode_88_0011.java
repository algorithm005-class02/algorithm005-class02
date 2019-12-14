package leetcode.week01;

//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
//
// 说明:
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
// 示例:
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
// Related Topics 数组 双指针
public class LeetCode_88_0011 {

    /**
     * 时间复杂度O(m+n) 空间复杂度O(m)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int i = 0, j = 0, temp = 0;
        while (i < m + n) {
            if (temp == m) {
                nums1[i] = nums2[j++];
            } else if (j == n) {
                nums1[i] = nums1_copy[temp++];
            } else if (nums1_copy[temp] < nums2[j]) {
                nums1[i] = nums1_copy[temp++];
            } else {
                nums1[i] = nums2[j++];
            }
            i++;
        }
    }

    /**
     * 时间复杂度O(m+n) 空间复杂度O(1)
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        //从后向前遍历，不需要额外空间
        int pmLeft = m - 1, pmRight = nums1.length - 1, pn = n - 1;
        while (pmRight >= 0) {
            if (pmLeft < 0) {
                nums1[pmRight] = nums2[pn--];
            } else if (pn < 0) {
                nums1[pmRight] = nums1[pmLeft--];
            } else if (nums1[pmLeft] < nums2[pn]) {
                nums1[pmRight] = nums2[pn--];
            } else {
                nums1[pmRight] = nums1[pmLeft--];
            }
            pmRight--;
        }
    }

}
