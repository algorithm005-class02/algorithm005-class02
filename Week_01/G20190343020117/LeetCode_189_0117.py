class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def reverse(nums, start, end):
            while start < end:
                temp = nums[end]
                nums[end] = nums[start]
                nums[start] = temp
                start += 1
                end -= 1
        n = len(nums)    
        k %= n
        reverse(nums, 0,  n - 1)
        reverse(nums, 0,  k - 1)
        reverse(nums, k,  n - 1)