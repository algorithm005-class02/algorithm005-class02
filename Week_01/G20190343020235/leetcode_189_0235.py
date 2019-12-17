"""
思路 1
暴力，旋转 k 次每次旋转一个元素
时间O(n*k) 空间 O(1)
思路 2
使用额外数组，将数组里下标为 i的放到(i+k)%数组长度的位置
时间 O(n) 空间 O(1)
思路 3
使用环状替换
如果我们直接把每一个数字放到它最后的位置，但这样的后果是遗失原来的元素。因此，我们需要把被替换的数字保存在变量 temp里面。然后，我们将被替换数字（temp）放到它正确的位置，并继续这个过程 n次， n是数组的长度。
但是存在一个问题如果 n%k==0其中 k=k%n，因为如果 k>n，那么移动 k 次相当于移动 k%n 次， 这种情况下，我们会发现在没有遍历所有数字的情况下回到出发数字。此时，我们应该从下一个数字开始再重复相同的过程。
时间O(n) 空间 O(1)
思路 4
使用反转
这个方法基于这个事实，当我们旋转数组 k 次，k%n个尾部元素会被移动到头部，剩下的元素会被向后移动
在这个方法中，我们首先将所有元素反转，然后反转前 k 个元素，再反转后面 n-k 个元素，就能得到想要的结果
时间O(n) 空间 O(1)
"""
# 思路 1 超时
class Solution1:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        for i in range(k):
            self.rotate_once(nums)
    
    def rotate_once(self, nums: List[int]) -> None:
        previous = nums[-1]
        for i in range(len(nums)):
            previous, nums[i] = nums[i], previous
        

# 思路 2 60ms 14.1mb
class Solution2:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        res = [0 for i in range(len(nums))]
        for i in range(len(nums)):
            res[(i+k)%len(nums)] = nums[i]
        for i in range(len(nums)):
            nums[i] = res[i]

# 思路 3

# 思路 4 56ms 14.1mb
class Solution4:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        nums = self.reverse(nums)
        nums[:(k%len(nums))] = self.reverse(nums[:(k%len(nums))])
        nums[(k%len(nums)):] = self.reverse(nums[(k%len(nums)):])
     
    def reverse(self, nums: List[int]) -> List:
        i, j = 0, len(nums)-1
        while i < j:
            nums[i], nums[j] = nums[j], nums[i]
            i, j = i+1, j-1
        return nums