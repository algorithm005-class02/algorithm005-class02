class Solution:
    # 1.课前尝试解题
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        if not nums1 or not nums2:
            return
        j = 0
        for i in range(m + n):
            if j == len(nums2):
                break
            if nums1[i] > nums2[j] or i == m + j:
                nums1.insert(i, nums2[j])
                j += 1
        while len(nums1) > m + n:
            nums1.pop()
    # 2.课后看题解答题
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        # 一行代码
        nums1[:] = sorted(nums1[:m] + nums2)