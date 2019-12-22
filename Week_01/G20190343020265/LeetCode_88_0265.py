#
# @lc app=leetcode.cn id=88 lang=python3
#
# [88] 合并两个有序数组
#

# @lc code=start
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
# 解法一, 直接合并然后进行排序
#        nums1[:] = sorted(nums1[:m] + nums2)  

# 解法二, 利用两个待合并数组有序的特性，进行归并操作，这里没有用从首元素开始逐一比较，
# 并归并到一个新数组中的方法，而是根据待合并数组已开辟的内存空间，在尾部增加一个指针，
# 用于标记和赋值尾部的空闲数组空间，而另设两个指针分别指向两个待处理数组，从数组的有效
# 数字位开始反遍历，比较得其大者放于空闲数组空间中。
# 但要注意一种情况是，无空闲空间得数组元素有小于空闲空间数组首元素的，需要将那些元素
# 一次性加入到目标数组中
        p = n + m -1
        p1 = m - 1
        p2 = n - 1
        while p1 >= 0 and p2 >= 0:
            if nums1[p1] > nums2[p2]:
                nums1[p] = nums1[p1]
                p1 -= 1
            else:
                nums1[p] = nums2[p2]
                p2 -= 1
            p -= 1
        
        nums1[:p2 + 1] = nums2[:p2 + 1]



# @lc code=end

