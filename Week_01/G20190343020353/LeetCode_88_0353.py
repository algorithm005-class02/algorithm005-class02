"""
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""


def merge(nums1, m, nums2, n):
    """
    采用双指针，从后往前遍历，最优时间复杂度为O(m+n)，空间复杂度为O(1)
    :type nums1: List[int]
    :type m: int
    :type nums2: List[int]
    :type n: int
    :rtype: None Do not return anything, modify nums1 in-place instead.
    """
    # 实际有三个指针，其中p和p1都是指向nums1
    p = m + n - 1   # 始终指向nums1要修改的位置
    p1 = m - 1      # 指向nums1中有值部分的未遍历的最后一个，因为都是排好序的，所以肯定也是最大的一个。
    p2 = n - 1      # 指向nums2中未遍历的最后一个，同理，肯定也是最大的数。

    # 从后往前遍历，只要指针大于等于0，说明还没有遍历完，任何一个数组的指针<0，则退出循环。
    while p1 >= 0 and p2 >= 0:
        # 都是各自数组中最大的数，将它们进行比较，就得到最终数组里的最大数。
        # 将当前最大数放到p的位置，并将当前数组的指针向左移动一位。
        if nums1[p1] > nums2[p2]:
            nums1[p] = nums1[p1]
            p1 -= 1
        else:
            nums1[p] = nums2[p2]
            p2 -= 1
        # 不管哪个大，p位置肯定是被修改过了的，所以要将p向左移动一位。
        p -= 1
    # 最后，不要忘了，nums2有可能没有遍历完
    if p2 >= 0:
        # 这时候剩下的数肯定都是最小的了，所以可以直接将它们放到nums1的开头就行了。
        nums1[:p2 + 1] = nums2[:p2 + 1]


if __name__ == '__main__':
    nums1 = [1, 2, 3, 0, 0, 0]
    m = 3
    nums2 = [2, 5, 6]
    n = 3

    merge(nums1, m, nums2, n)
    print(nums1)
