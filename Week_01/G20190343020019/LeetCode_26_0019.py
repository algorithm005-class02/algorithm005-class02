class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        size = len(nums)
        if size == 0:
            return 0
        j, pre = 1, nums[0]
        for i in range(1, size):
            if nums[i] != pre:
                if i != j:
                    nums[j] = nums[i]
                j += 1
                pre = nums[i]
        return j