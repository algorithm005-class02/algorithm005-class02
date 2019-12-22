#
# @lc app=leetcode.cn id=26 lang=python3
#
# [26] 删除排序数组中的重复项
#
# https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/
#
# algorithms
# Easy (47.37%)
# Likes:    1216
# Dislikes: 0
# Total Accepted:    210.9K
# Total Submissions: 444.1K
# Testcase Example:  '[1,1,2]'
#
# 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
#
# 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
#
# 示例 1:
#
# 给定数组 nums = [1,1,2],
#
# 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
#
# 你不需要考虑数组中超出新长度后面的元素。
#
# 示例 2:
#
# 给定 nums = [0,0,1,1,1,2,2,3,3,4],
#
# 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
#
# 你不需要考虑数组中超出新长度后面的元素。
#
#
# 说明:
#
# 为什么返回数值是整数，但输出的答案是数组呢?
#
# 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
#
# 你可以想象内部操作如下:
#
# // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
# int len = removeDuplicates(nums);
#
# // 在函数里修改输入数组对于调用者是可见的。
# // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
# for (int i = 0; i < len; i++) {
# print(nums[i]);
# }
#
#
#

# @lc code=start


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # 遍历数组，按顺序记下每个数字的出现次数; 第二遍写进入
        # Time: O(N); Space: O(N)

        # 双指针：j维护当前待写入的位置；i遍历的位置
        # TimeL O(n=N); Space: O(1)
        # Accepted
        # 161/161 cases passed (84 ms)
        # Your runtime beats 99.82 % of python3 submissions
        # Your memory usage beats 99.34 % of python3 submissions (14.3 MB)
        j, L = 1, len(nums)
        if L == 0:              # 边界条件
            return 0
        for i in range(1, L):
            if nums[i] != nums[j-1]:
                nums[j] = nums[i]
                j += 1
        return j
        # @lc code=end
