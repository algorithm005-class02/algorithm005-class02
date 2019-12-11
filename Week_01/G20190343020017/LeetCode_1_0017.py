class Solution:
    # 1.课前尝试解题
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 虽然通过，但是执行时间6000ms
        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]