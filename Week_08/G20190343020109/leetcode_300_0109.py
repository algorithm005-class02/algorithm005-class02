class Solution:
    def lengthOfLIS0(self, nums: List[int]) -> int:
        if not nums: return 0
        dp = [1] * len(nums)
        for i in range(len(nums)):
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i],dp[j] + 1)
        return max(dp)

    def lengthOfLIS1(self, nums: List[int]) -> int:
        tails,res = [0]*len(nums),0
        for num in nums:
            i,j = 0,res
            while i < j:
                m = (i+j) // 2
                if tails[m] < num:
                    i = m + 1
                else:
                    j = m
            tails[j] = num
            if j == res:res += 1
        return res