class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num = dict()
        for i in range(0, len(nums)):
            a = nums[i]
            b = target - a
            if b in num:
                return [num[b], i]
            else:
                num[a] = i