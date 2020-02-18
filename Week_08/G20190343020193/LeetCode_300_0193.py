from typing import List
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums: return 0
        dp = [1] * len(nums) #初始化[1,1,1,1,1,1,1,1]
        for i in range(len(nums)):
            print("i:", i)
            for j in range(i):
                print("j:",j)
                if nums[j] < nums[i]: 
                    print("dp[i]",dp[i])
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)