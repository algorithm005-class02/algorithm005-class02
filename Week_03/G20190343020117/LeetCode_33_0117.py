# 1.Solution to violence
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums: 
            return -1
        for i, num in enumerate(nums):
            if num == target:
                return i
        return -1

# 2.Binary Search
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums: 
            return -1
        left, right = 0, len(nums) - 1 
        while left <= right: 
            mid = (left + right) // 2 
            if nums[mid] == target: 
                # find the target!! 
                return mid 
            elif nums[mid] >= nums[left]:
                if nums[left] <= target <= nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1 
            else: 
                if nums[mid] <= target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1