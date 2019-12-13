"""
思路 1：
暴力，两个数组合并后排序。时间复杂度: O((n+m)log(n+m)) 空间: O(1)
思路 2：
双指针，首先先把数组 1 的前 m 个元素拷到另一个数组中，作为数组 3。两个指针分别指针指向数组开头，比较大小然后向小的向数组 1 中写入，直到两个数组的元素都加入
思路 3：
双指针？或者说三指针。两个指针不指向开头，而是指向结尾，然后再 m+n 位置作为起始位置，比较两个指针对应元素的大小，大的赋值，然后指针移动，知道元素都赋值
"""


# 思路 1 44ms 12.7mb
class Solution1:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        nums1[m: m+n] = nums2
        nums1[:m+n] = sorted(nums1[:m+n])
# 思路 2 36ms 12.7mb
class Solution2:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        tmp_nums1 = nums1[:m]
        i, j, k = 0, 0, 0
        while i < m and j < n:
            if tmp_nums1[i] < nums2[j]:
                nums1[k] = tmp_nums1[i]
                i, k = i+1, k+1
            else:
                nums1[k] = nums2[j]
                j, k = j+1, k+1
        while i < m:
            nums1[k] = tmp_nums1[i]
            i, k = i+1, k+1
        while j < n:
            nums1[k] = nums2[j]
            j, k = j+1, k+1
# 思路 3 40ms 12.6mb
class Solution3:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        while m > 0 and n > 0:
            if nums1[m-1] > nums2[n-1]:
                nums1[m+n-1] = nums1[m-1]
                m -= 1
            else:
                nums1[m+n-1] = nums2[n-1]
                n -= 1
        if n > 0:
            nums1[:n] = nums2[:n]