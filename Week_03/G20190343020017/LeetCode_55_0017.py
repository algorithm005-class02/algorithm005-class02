# 回溯递归 超时
class Solution:
    def canJump(self, nums) -> bool:
        if not nums or len(nums) == 1 or nums[0] + 1 == len(nums):
            return True
        for i in range(0, nums[0]):
            if self.canJump(nums[nums[0] - i:]):
                return True
        return False
        
# 从后向前贪心
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        current, index = n - 1, n - 1
        while index > 0:
            index -= 1
            if nums[index] >= current - index:
                current = index
        return not current