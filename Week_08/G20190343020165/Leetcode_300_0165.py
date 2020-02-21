class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        count = len(nums)
        dp = [1] * count
        for i in range(count):
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i],dp[j] + 1)
        
        return max(dp)
