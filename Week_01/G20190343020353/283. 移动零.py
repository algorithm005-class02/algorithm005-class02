"""
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/move-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""


def move_zeros(nums):
    """
    :type nums: List[int]
    :rtype: None Do not return anything, modify nums in-place instead.
    """
    # 最后一个非零数字出现的索引，也就是说在last_none_zero_index位置之前的所有数字，确保都是非零数字。
    last_none_zero_index = 0
    for i in range(len(nums)):
        if nums[i]:
            nums[i], nums[last_none_zero_index] = nums[last_none_zero_index], nums[i]
            last_none_zero_index += 1
    list()


if __name__ == '__main__':
    test_nums = [0, 1, 0, 3, 12]
    move_zeros(test_nums)
    print(test_nums)
