"""
思路：
排序+双指针
因为不能有重复解，所以考虑先排序，然后从头遍历，固定一个数，然后左右指针，遍历，找所有解
时间: O(n^2) 空间: O(1)
"""
# 900ms 16.2mb
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        for i in range(len(nums)-2):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            l, r = i+1, len(nums) - 1
            while l < r:
                s = nums[i] + nums[l] + nums[r]
                if s < 0:
                    l += 1
                elif s > 0:
                    r -= 1
                else:
                    res.append([nums[i], nums[l], nums[r]])
                    while l < len(nums)-1 and nums[l] == nums[l+1]:
                        l += 1
                    while r > 1 and nums[r] == nums[r-1]:
                        r -= 1
                    l, r = l + 1, r - 1
        return res