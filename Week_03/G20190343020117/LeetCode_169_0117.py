class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # recursion terminator 
        if not nums:
            return None
        if len(nums) == 1:
            return nums[0]
        # conquer subproblems 
        a = self.majorityElement(nums[:len(nums)//2])
        b = self.majorityElement(nums[len(nums)//2:])
        # process and generate the final result 
        if a == b:
            return a
        return [b, a][nums.count(a) > len(nums)//2]