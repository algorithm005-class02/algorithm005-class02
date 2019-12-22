package com.smart33690;

/**
 * @Author: Smart
 * @Date: 2019/12/15 19:56
 */

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class LeetCode088 {
    public static void main(String[] args) {

    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m+n-1;
        int p1 = m-1;
        int p2 = n-1;
        //两个数组对应数据比较，取最大值放后边
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        //如果nums1所有数据都比nums2大，可能存在nums1的前几个元素都是空
        //把nums2剩余的拷贝进nums1
        System.arraycopy(nums2,0,nums1,0,p2+1);
    }
}
