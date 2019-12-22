#
# @lc app=leetcode.cn id=88 lang=python3
#
# [88] 合并两个有序数组
#
# https://leetcode-cn.com/problems/merge-sorted-array/description/
#
# algorithms
# Easy (45.86%)
# Likes:    362
# Dislikes: 0
# Total Accepted:    90.7K
# Total Submissions: 197.6K
# Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
#
# 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
#
# 说明:
#
#
# 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
# 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
#
#
# 示例:
#
# 输入:
# nums1 = [1,2,3,0,0,0], m = 3
# nums2 = [2,5,6],       n = 3
#
# 输出: [1,2,2,3,5,6]
#
#

# @lc code=start


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        # 两个指针，分别遍历nums1和nums2, 新数组存nums3, num3 -> nums1
        # T: O(n+m), S: O(n+m)

        # 从尾部开始
        # T: O(n+m), S: O(1)
        # 59/59 cases passed (36 ms)
        # Your runtime beats 98.74 % of python3 submissions
        # Your memory usage beats 99.54 % of python3 submissions (12.5 MB)

        while m > 0 and n > 0:
            if nums1[m-1] > nums2[n-1]:
                nums1[m+n-1] = nums1[m-1]
                m -= 1
            else:
                nums1[m+n-1] = nums2[n-1]
                n -= 1

        if n > 0:
            # for k in range(j):
            #     nums1[k] = nums2[k]
            nums1[:n] = nums2[:n]

        # @lc code=end
