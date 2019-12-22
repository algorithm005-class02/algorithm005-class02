"""
move zeros
思路1:
暴力
遍历,如果遇到 0，则遍历后面的元素找到第一个不为 0 的元素 交换 时间: O(n^2) 空间: O(1)
思路2:
首先遍历一遍数组，找到 0 的个数，然后构建一个新数组，先把原数组中的非零元素 push 进去，然后把 所有的 0 push 进数组，最后将值赋予原数组
时间: O(n) 空间: O(n)
思路 3:
两个指针，a遍历整个数组，b一个代表最后一个 非 0 的元素的位置，遍历时，如果为 非 0 元素，将a 位置元素赋予 b 位置元素，然后 b自增，最后将 0 补全
时间: O(n) 空间: O(1)
思路 4:
与思路 3 类似，不再赋值，而是改成交换两个位置的值
"""

#思路 1
# 300ms 13.9mb
class Solution1: 
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        for i in range(len(nums)):
            if nums[i] == 0:
                for j in range(i+1, len(nums)):
                    if nums[j] != 0:
                        nums[j], nums[i] = nums[i], nums[j]
                        break

#思路 2
#68ms 13.9Mb
class Solution2:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if not nums:
            return
        ans = []
        num_zeros = len(list(filter(lambda x: x == 0, nums)))
        for num in nums:
            if num != 0:
                ans.append(num)
        for i in range(num_zeros):
            ans.append(0)
        for i in range(len(nums)):
            nums[i] = ans[i]
#思路 3
#44ms 14mb
class Solution3:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        last_non_zero_index = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[last_non_zero_index] = nums[i]
                last_non_zero_index += 1
        for i in range(last_non_zero_index, len(nums)):
            nums[i] = 0

# 思路 4
# 44ms 13.9mb
class Solution4:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        last_non_zero_index = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[last_non_zero_index], nums[i] = nums[i], nums[last_non_zero_index]
                last_non_zero_index += 1
    
                