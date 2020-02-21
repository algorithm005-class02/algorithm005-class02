class Solution:
    # 递归法
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        self._subsets(nums, [], result)
        return result
    
    def _subsets(self, nums, current, result):
        # terminator
        if not nums:
            result.append(current)
            return
        
        # process
        temp = current[:]
        temp.append(nums[0])

        # drill down 
        self._subsets(nums[1:], current, result)
        self._subsets(nums[1:], temp, result)

    # 迭代法
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        for num in nums:
            result += [item + [num] for item in result]
        return result