# 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
#
# 注意：答案中不可以包含重复的三元组。
#
# 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
#
# 满足要求的三元组集合为：
# [
#  [-1, 0, 1],
#  [-1, -1, 2]
# ]
#
# Related Topics 数组 双指针


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        res = []
        for k in range(len(nums)):
            if nums[k] > 0: break
            if k > 0 and nums[k] == nums[k - 1]: continue
            l, r = k + 1, len(nums) - 1
            while l < r:
                s = nums[l] + nums[k] + nums[r]
                if s == 0:
                    res.append([nums[k], nums[l], nums[r]])
                    l += 1
                    r -= 1
                    while l < r and nums[l] == nums[l - 1]: l += 1
                    while l < r and nums[r] == nums[r + 1]: r -= 1
                elif s < 0:
                    l += 1
                    while l < r and nums[l] == nums[l - 1]: l += 1
                else:
                    r -= 1
                    while l < r and nums[r] == nums[r + 1]: r -= 1
        return res


# leetcode submit region end(Prohibit modification and deletion)
Solution().threeSum([-1, 0, 1, 2, -1, -4])
