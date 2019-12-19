class Solution:
    # 1.课前尝试解题
    def rotate(self, nums, k) -> None:
        # 方法一，不考虑题目O(1)空间复杂度的要求
        '''
        k = k % len(nums)
        temp = nums[-k:] + nums[0:-k]
        for i in range(len(nums)):
            nums[i] = temp[i]
        '''
        # 方法二，用O(1)空间复杂度，测试没问题，但是提交输入过长数组时超时
        k = k % len(nums)
        for i in range(k):
            v = nums[-1]
            for n in range(len(nums) - 1):
                nums[-n-1] = nums[-n-2]
            nums[0] = v
    # 2.课后看题解解题
    def rotate(self, nums, k) -> None:
        # 参考官方题解方法四：翻转法
        n = len(nums)
        k = k % n
        nums[:] = nums[::-1]
        nums[0:k] = nums[k-n-1:-n-1:-1]
        nums[k:n] = nums[-1:k-n-1:-1]