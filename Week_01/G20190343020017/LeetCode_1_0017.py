class Solution:
    # 1.课前尝试解题
    '''
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 虽然通过，但是执行时间6000ms
        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
    '''
    # 2.课后看题解再次解题（哈希表方法，56-64ms）
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = dict()
        ran = range(len(nums))
        # 存入哈希表
        for i in ran:
            map[nums[i]] = i
        # 再次遍历查找结果
        for i in ran:
            index = map.get(target - nums[i])
            if index and index != i:
                return [i, index]
