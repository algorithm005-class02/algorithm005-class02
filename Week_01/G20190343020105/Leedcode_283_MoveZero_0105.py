'''
python 数组操作教程：https://www.cnblogs.com/volcao/p/8630378.html

'''
#remove append flow
class Solution_one:
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        数组：查询快，插入和删除慢
        耗时：60～100毫秒
        内存：12。8MB
        评价：移除和添加显然在数组中耗时较长，不是最优解
        思路：计算n出现的次数，遍历移除n次，末尾添加出现n次数
        """
        n = 0
        for i in range(nums.count(n)):
            nums.remove(n)
            nums.append(n)


#slow
class Solution_two:
    def moveZeroes(self,nums):
        '''
        :param nums:
        :return:
        1、过滤所有非零数据，非零数据根据K值向前移动
        2、将K小于数组的宽度时，替换所有的数据为0

        执行用时：48 ms
        内存消耗：13.8 MB
        '''
        k = 0
        for i in nums:
            if i != 0:
                nums[k] = i
                k+=1

        while(k < len(nums)):
            nums[k] = 0
            k+=1


class Solution_three:
    def moveZero(self,nums):
        '''
        :param nums:
        :return:
        执行用时：52 ms
        内存消耗：13.8 MB
        '''
        j = -1
        for i in range(len(nums)):
            if nums[i] != 0:
                j+=1
                temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp



class Solution_four:
    def moveZero(self,nums):
        '''
        :param nums:
        :return:
        O(n)复杂度
        执行用时：52 ms
        内存消耗：13.8 MB
        1、非零
        2、非零全部移动到最前
        3、后面全部补0
        '''
        no_zero = []
        for i in nums:
            if i != 0:
                no_zero.append(i)

        for i in range(len(no_zero)):
            temp = no_zero[i]
            nums[i] = temp

        for i in range(len(no_zero),len(nums)):
            nums[i] = 0

