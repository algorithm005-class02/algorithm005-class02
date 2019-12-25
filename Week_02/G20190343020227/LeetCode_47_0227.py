#全排列2，这道题其实就是在全排列的基础上加一个判断
class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res,n = [],len(nums)
        def fincombine(first):
            tmp = nums[:]
            if first == n and tmp not in res:
                res.append(tmp)
            for i in range(first,n):
                nums[i],nums[first] = nums[first],nums[i]
                fincombine(first + 1)
                nums[i],nums[first] = nums[first],nums[i]
        fincombine(0)
        return res
