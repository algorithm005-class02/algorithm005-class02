# python3

claass Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if not nums: return []        
        # # 法1 暴力法
        # for i in range(len(nums) - 1):
        #     for j in range(i+1, len(nums)):
        #         if nums[i] + nums[j] == target:
        #             return list([i,j])
        # return []
        

        # 法2 map 方法
        map_store = {}
        for i, x in enumerate(nums):
            if target - x in map_store.keys():
                return set([map_store.get(target-x),i])
            map_store[x] = i
        return []
