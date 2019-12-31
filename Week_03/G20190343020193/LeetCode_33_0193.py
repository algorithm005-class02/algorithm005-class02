class Solution:
    def search(self, nums, target):
        if not nums:
            return -1

        left, right = 0, len(nums) - 1

        while left <= right:
            mid = (left + right) / 2
            if target == nums[mid]:
                return mid

            elif nums[mid] < nums[right]: #在右半边区间
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
            else:                         #在左半边区间
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
        return -1