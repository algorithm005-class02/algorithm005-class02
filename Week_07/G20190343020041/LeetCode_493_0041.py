# 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
#
# 你需要返回给定数组中的重要翻转对的数量。
#
# 示例 1:
#
#
# 输入: [1,3,2,3,1]
# 输出: 2
#
#
# 示例 2:
#
#
# 输入: [2,4,3,5,1]
# 输出: 3
#
#
# 注意:
#
#
# 给定数组的长度不会超过50000。
# 输入数组中的所有数字都在32位整数的表示范围内。
#
# Related Topics 排序 树状数组 线段树 二分查找 分治算法


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        return self.reversePairsSub(nums, 0, len(nums) - 1)

    def reversePairsSub(self, nums: List[int], l, r) -> int:
        if r <= l: return 0
        mid = l + ((r - l) >> 1)
        cnt = self.reversePairsSub(nums, l, mid) + self.reversePairsSub(nums, mid + 1, r)
        i, j, k, p = l, mid + 1, 0, mid + 1
        merge = [0] * (r - l + 1)

        while i <= mid:
            while p <= r and nums[i] > 2 * nums[p]: p += 1
            cnt += p - (mid + 1)
            while j <= r and nums[i] >= nums[j]:
                merge[k] = nums[j]
                k += 1
                j += 1
            merge[k] = nums[i]
            k += 1
            i += 1
        while j <= r:
            merge[k] = nums[j]
            k += 1
            j += 1
        for q in range(r - l + 1):
            nums[q + l] = merge[q]
        return cnt


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().reversePairs([1, 3, 2, 3, 1]))
