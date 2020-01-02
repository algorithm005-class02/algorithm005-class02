# 二分查找法
class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        while nums[left] > nums[right]:
            mid = left + (right - left) // 2
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid
        return nums[left]

# 一行
class Solution:
    def findMin(self, nums: List[int]) -> int:
        return sorted(nums)[0]