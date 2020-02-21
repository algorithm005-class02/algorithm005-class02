class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        closer = nums[0] + nums[1] + nums[2]
        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]: continue
            l, r = i + 1, len(nums) - 1
            while l < r:
                s = nums[i] + nums[l] + nums[r]
                if abs(s - target) < abs(closer - target):
                    closer = s
                if s == target:
                    return s
                elif s < target:
                    l += 1
                    while l < r and nums[l] == nums[l - 1]: l += 1
                else:
                    r -= 1
                    while l < r and nums[r] == nums[r + 1]: r -= 1
        return closer