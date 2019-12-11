# hashmap
def twoSum(self, nums: List[int], target: int) -> List[int]:
    hash_map = {}
    for i,num in enumerate(nums):
        another_num = target - num
        if another_num in hash_map:
            return [hash_map[another_num], i]
        hash_map[num] = i
    return None

# 暴力法,循环遍历nums[i]和nums[j]
def twoSum(self, nums: List[int], target: int) -> List[int]:
    for i in range(len(nums)-1):
        for j in range(i,len(nums)):
            if nums[i] + nums[j] == target and i!=j:
                return [i,j]