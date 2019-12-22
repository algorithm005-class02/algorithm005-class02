'''
 @method "两遍哈希表（字典）法"
 @explain 首先利用字典记录了nums里每个num的值和位置，这样在遍历中能更快地找到target - num对应的键及其下标
 @complexity 时间复杂度：O(n) ,空间复杂度：O(1)
 @param {number[]} nums
 @param {number} target
 @return {number[]}
'''
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict = {}
        # 1.利用enumerate把数组中的值和键都放到字典里
        for index,num in enumerate(nums):
            dict[num] = index
        for i,num in enumerate(nums):
            # 2.查出差值
            j = dict.get(target - num)
            # 3.判断差值是否存在及不让重复利用数组中同样的元素
            if j is not None and j != i:
                return [i,j]
