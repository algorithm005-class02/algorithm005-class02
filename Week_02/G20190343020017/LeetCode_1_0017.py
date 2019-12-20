class Solution:
    # 再次解题，一次通过，尝试了一边循环，边遍历边判断的方法
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        m = {}
        for i, num in enumerate(nums):
            if target - num in m:
                return [m.get(target - num), i]
            else:
                m[num] = i
