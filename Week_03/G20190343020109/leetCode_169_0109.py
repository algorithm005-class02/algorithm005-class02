import collections

class Solution:
    def majorityElement0(self, nums: List[int]) -> int:
        dic = {}
        for n in nums:
            dic[n] = dic.get(n,0)+1
        return max(dic,key=dic.get)

    def majorityElement1(self, nums: List[int]) -> int:
        counts = collections.Counter(nums)
        return max(counts.keys(),key=counts.get)