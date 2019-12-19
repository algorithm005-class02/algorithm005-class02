'''
题目要求：给定一个数组移动k次，其中K是非零整数
输入：[1,2,3,4,5,6,7,8]
分析：
移动1位
[8,1,2,3,4,5,6,7]
移动两位
[7,8,1,2,3,4,5,6]
移动三位
[6,7,8,1,2,3,4,5]
......
由此可得
移动k位
[最后K位树，前面n-k位数]

以下解题思路通过换位、反转、切片、插入四种方法实现
'''

nums = [1,2,3,4,5,6,7,8]

class Solution:
    def rotate(self,nums,k):
        '''
        :param nums:
        :param k:
        :return:
        分析：
        1、移动k位，分为两段进行
        2、将[0.n-k-1],前后换位，实现反转效果
        3、再将[n-k,n-1],前后换位，实现反转
        4、实现首位换位，最后实现移动效果
        '''
        n = len(nums)
        def swap(l,r):
            while (l<r):
                nums[l],nums[r] = nums[r],nums[l]
                l=l+1
                r=r-1

        swap(0,n-k-1)
        swap(n-k,n-1)
        swap(0,n-1)
        return nums



class Solution:
    def rorate(self,nums,k):
        '''
        :param nums:
        :param k:
        :return:
        1、整体反转
        2、【0，k】，进行反转
        3、【k,n-k】，在进行反转

        '''
        n = len(nums)
        nums[:] = nums[::-1]  #整体反转
        #局部反转
        nums[:k] = nums[:k][::-1]
        #局部反转
        nums[k:] = nums[k:][::-1]
        print(nums)
        return nums


class Solution:
    def rorate(self,nums,k):
        '''
        :param nums:
        :param k:
        :return:
         切片方式
        '''

        n = len(nums)
        nums[:] = nums[:n-k] +nums[n-k:]

        return nums


class Solution:
    def rotate(self, nums, k):
        n = len(nums)
        k %= n
        for _ in range(k):
            nums.insert(0, nums.pop())
            print(nums)

        return nums

