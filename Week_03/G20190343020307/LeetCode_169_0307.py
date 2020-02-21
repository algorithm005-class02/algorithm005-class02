class Solution:
    def majorityElement(self, nums: List[int]) -> int:
       # 暴力法
        # majority_count = len(nums)//2
        # for num in nums:
        #     count = sum(1 for elem in nums if elem == num)
        #     if count > majority_count:
        #         return num
        # set
        set1 = set(nums)
        for i in set1:
            if nums.count(i)> len(nums)//2:
                return i

