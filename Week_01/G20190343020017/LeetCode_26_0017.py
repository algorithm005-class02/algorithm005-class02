class Solution:
    # 1.课前尝试解题（之前已经做过这个题目看过题解）
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:
            return 0
        slow, fast = 0, 0
        for fast in range(len(nums)):
            if nums[fast] != nums[slow]:
                slow += 1
                nums[slow] = nums[fast]
        return slow + 1