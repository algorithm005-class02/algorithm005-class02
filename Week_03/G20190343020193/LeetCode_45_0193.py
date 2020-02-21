from typing import List
class Solution:
    def jump(self, nums: List[int]) -> int:
        step=0 
        end=0 
        max_bound=0 
        for i in range(len(nums)-1):
            max_bound=max(max_bound,nums[i]+i) 
            if(i==end): 
                step+=1
                end=max_bound
        return step