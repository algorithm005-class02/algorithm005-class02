class Solution:
    # def twoSum(self, nums: List[int], target: int) -> List[int]:
    #     for i in range(len(nums)):
    #         for j in range(len(nums)):
    #             if (i != j) and (nums[i] + nums[j] == target):
    #                 return [i, j]
    def twoSum(self, nums, target):
        dict_rem = {}
        for i in range(len(nums)):
            if target - nums[i] in dict_rem:
                return [dict_rem[target - nums[i]], i]
            else:
                dict_rem[nums[i]] = i

        # for i in range(len(nums)):
        #     if nums[i] in dict_rem:
        #         return [dict_rem[nums[i]], i]
        #     else:
        #         dict_rem[target - nums[i]] = i
