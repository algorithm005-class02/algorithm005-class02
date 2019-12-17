'''
方法：“三次反转”
'''
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        #获取数组长度
        n = len(nums)
        #忽略重复后实际移动次数
        k %= n
        #反转方法
        def swap(l,r):
            while(l<r):
                nums[l],nums[r] = nums[r],nums[l]
                l = l + 1
                r = r - 1
        #整体反转
        swap(0,n - 1)
        #前K个反过来
        swap(0,k - 1)
        #后n-k个反过来，完成
        swap(k,n - 1)


