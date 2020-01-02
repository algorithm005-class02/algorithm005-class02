# 暴力遍历
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        for index, num in enumerate(nums):
            if num == target:
                return index
        return -1

# 暴力还原 + 二分查找
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # 暴力还原
        n, index = len(nums), 0
        for index in range(1, n):
            if nums[index] < nums[index - 1]:
                break
            elif index == n - 1:
                index = 0
                break
        nums = nums[index:] + nums[:index]
        # 二分查找
        left, right = 0, n - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return (mid + index) % n
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return -1

# 二分查找
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # 二分查找
        n = len(nums)
        left, right = 0, n - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < nums[right]:
                if nums[mid] < target and nums[right] >= target:
                    left = mid + 1
                else:
                    right = mid - 1
            else:
                if nums[mid] > target and nums[right] < target:
                    right = mid - 1
                else:
                    left = mid + 1
        return -1