class Solution(object):
	def canJump(self, nums):
		goal = len(nums) - 1
		for i in range(len(nums))[::-1]:
			if i + nums[i] >= goal: 
				goal = i
		return not goal