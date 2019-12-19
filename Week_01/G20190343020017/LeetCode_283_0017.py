class Solution:
    # 1.课前尝试解题（方法一虽然AC，但执行时间600+ms）
    '''
    def moveZeroes(self, nums: List[int]) -> None:
        # 方法一
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
    '''
    # 2.课后第二遍做题（按照超哥的思路）：68ms
    '''
    def moveZeroes(self, nums: List[int]) -> None:
        j = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[j] = nums[i]
                if i != j:
                    nums[i] = 0
                j += 1
    '''
    # 按照题解中其他思路（不再判断i，j是否相等，也是官方方法二）:52ms
    '''
    def moveZeroes(self, nums: List[int]) -> None:
        j = 0
        # 第一步循环只负责把非零元素前移
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[j] = nums[i]
                j += 1
        # 第二步循环把非零元素个数之后的元素置0
        for i in range(j, len(nums)):
            nums[i] = 0
    '''
    # 按照官方题解方法三：56ms
    def moveZeroes(self, nums: List[int]) -> None:
        j = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[j], nums[i]= nums[i], nums[j]
                j += 1
