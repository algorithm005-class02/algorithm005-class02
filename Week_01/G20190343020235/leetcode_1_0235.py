"""
思路 1:
暴力，两重循环，找到，返回下标
思路 2：
先做一个哈希表，num 做 key，下标做 value,然后遍历数组，看 target-num 在哈希表中是否存在，如果存在，则返回下标
思路 3：
将上述两个过程合并，边遍历，边构建哈希表
"""
#思路 1
# 6472ms 13.7mb
class Solution1:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        length = len(nums)
        for i in range(length):
            for j in range (i+1, length):
                if nums[i] + nums[j] == target:
                    return i, j

#思路 2
#48ms 14.8mb
class Solution2:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        buffer_dict = {nums[i]: i for i in range(len(nums))}
        for i in range(len(nums)):
            if (target-nums[i]) in buffer_dict:
                res_idx = buffer_dict[target-nums[i]]
                if res_idx != i:
                    return i, buffer_dict[target-nums[i]]

#思路 3
# 52ms 14.2mb
class Solution3:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        buffer_dict = {}
        for i in range(len(nums)):
            if nums[i] in buffer_dict:
                return i, buffer_dict[nums[i]]
            else:
                buffer_dict[target-nums[i]] = i