class Solution:
    # hash表统计个数
    def majorityElement(self, nums: List[int]) -> int:
        counts, n = {}, len(nums) // 2
        for num in nums:
            counts[num] = counts.get(num, 0) + 1
            if counts[num] > n:
                return num
    
    # 排序法
    def majorityElement(self, nums: List[int]) -> int:
        nums.sort()
        return nums[len(nums) // 2]

    # 投票算法
    def majorityElement(self, nums: List[int]) -> int:
        count, candi = 0, None
        for num in nums:
            if count == 0:
                candi = num
            count += (1 if num == candi else -1)
        return candi