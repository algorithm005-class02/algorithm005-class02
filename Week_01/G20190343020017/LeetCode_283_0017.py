class Solution:
    # 1.课前尝试解题（方法一虽然AC，但执行时间600+ms）
    def moveZeroes(self, nums: List[int]) -> None:
        # 方法一
        '''
        for i in range(len(nums)):
            if nums[i] == 0:
                n = i + 1
                while n < len(nums):
                    if nums[n] != 0:
                        nums[i], nums[n] = nums[n], 0
                        break
                    n += 1
                else:
                    break
        '''
        # 方法二，对n的取值计算优化，执行时间44ms
        n = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                n = i + 1 if n < i else n + 1
                while n < len(nums):
                    if nums[n] != 0:
                        nums[i], nums[n] = nums[n], 0
                        break
                    n += 1
                else:
                    break