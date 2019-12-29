#
# @lc app=leetcode.cn id=88 lang=python3
#
# [88] 合并两个有序数组
#
# @lc code=start
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        p1 = m - 1
        p2 = n - 1
        p = p1 + p2 + 1

        while p >= p1 and p1 >= 0 and p2 >= 0:
            n1 = nums1[p1]
            n2 = nums2[p2]
            
            if n2 > n1:
                nums1[p] = n2
                p2 -= 1
            else:
                nums1[p] = n1
                p1 -= 1
            p -= 1
        if p2 >= 0:
            nums1[:p+1] = nums2[:p2+1]
# @lc code=end

