import bisect


class Solution:
    def reversePairs(self, nums):
        ri, res, n = [], 0, len(nums)
        for i in reversed(range(0, n)):
            res += bisect.bisect_left(ri, nums[i])
            bisect.insort(ri, 2 * nums[i])
        return res
