class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # 回溯
        return self.backtrace(nums)

    def backtrace(self, nums):
        """
        将问题分解为从 nums 的一半找众数，分解到 nums 为一个元素为止
        """
        if len(nums) == 1:
            # 分解到只有一个元素，众数就是自己
            return nums[0]

        half = int(len(nums)/2)
        left_max_num = self.backtrace(nums[:half])
        right_max_num = self.backtrace(nums[half:])
        
        if left_max_num == right_max_num:
            return left_max_num
        else:
            # 如果两个数的出现的次数一样，则随机一个数为众数
            return [right_max_num, left_max_num][nums.count(left_max_num) > half]
