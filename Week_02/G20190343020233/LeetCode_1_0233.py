from utils.timer import timethis


class Solution:
    """
    Clarification:
    1. 只有一个解
    2. 每个值只能用一次
    3. 可能有重复的值？
    """
    """
    1. 暴力：遍历寻找 target-current
    2. dict 
    """
    @timethis
    def twoSum(self, nums, target):
        """
        解法一
        """
        for i in range(len(nums)):
            find_num = target - nums[i]
            if find_num in nums[i+1:]:
                return [i, nums[i+1:].index(find_num) + i + 1]

    @timethis
    def twoSum1(self, nums, target):
        """
        解法2：使用被找的数字作为key，将主动找的下标作为value
        """
        d = {}
        for i in range(len(nums)):
            if nums[i] in d:
                return [d[nums[i]], i]
            else:
                d[target-nums[i]] = i




if __name__ == '__main__':
    test = Solution()
    print(test.twoSum1([2, 7, 11, 15], 9))
    print(test.twoSum1([3, 3], 6))



