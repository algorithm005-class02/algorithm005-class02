class Solution(object):
    #回溯算法
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res ,n = [] ,len(nums)
        def backtrack(k,tmp):
            if tmp not in res:
                res.append(tmp)
            for j in range(k,n): #枚举
                backtrack(j+1,tmp+[nums[j]]) #回溯
        backtrack(0,[])
        return res