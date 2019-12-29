"""
思路 1：
暴力
滑动所有窗口，然后找到窗口中的最大值
时间 O(N*k) 空间 O(1)
思路 2：
使用双端队列，队列中保存元素的索引，首先先处理前 k 个元素，初始化双端队列，遍历剩下的元素，在每一步，清理双向队列，只保留窗口中的元素，然后把队列中小于当前元素的都出队，保证队列左端是最大数的索引
时间 O(N) 空间 O(N)
思路 3：
动态规划
将数组分成有 k 个元素的块，开头元素为 i，结尾元素为 j 的当前滑动窗口可能在一个块内，也可能在两个块内，
对于情况 1，建立数组 left，left[j]表示从块的开始到下标 j的最大元素，方向左->右
对于情况 2，建立数组 right，其中 right[j]是从块的结尾到下标 j的最大元素，方向从右->左
两个数组可以提供两个块内元素的全部消息，从下标 i 到下标 j的滑动窗口，left[j]是左侧块内最大的元素，right[i]是右侧块内最大的元素，因此滑动窗口中最大的元素就是 max(left[j], right[i])
时间O(N) 空间 O(N)
"""

# 1 712ms 19.4mb
class Solution1:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        if n * k == 0:
            return []
        if k == 1:
            return nums
        
        return [max(nums[i:i+k]) for i in range(n-k+1)]

# 2 164ms 19.5mb
class Solution2:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        from collections import deque
        n = len(nums)
        if n * k == 0:
            return []
        if k == 1:
            return nums
        
        def clean_queue(i):
            if sliding_windows and sliding_windows[0] == i - k:
                sliding_windows.popleft()
            while sliding_windows and nums[sliding_windows[-1]] < nums[i]:
                sliding_windows.pop()
                
        res = [-(1<<32)]
        sliding_windows = deque()
        
        for i in range(k):
            clean_queue(i)
            sliding_windows.append(i)
            if res[0] < nums[i]:
                res[0] = nums[i]
        for i in range(k, n):
            clean_queue(i)
            sliding_windows.append(i)
            res.append(nums[sliding_windows[0]])
        return res

# 3 192ms 19.5mb
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        if n * k == 0:
            return []
        if k == 1:
            return nums
        
        left = [0 for _ in range(n)]
        right = [0 for _ in range(n)]
        left[0] = nums[0]
        right[n-1] = nums[n-1]
        for i in range(1, n):
            if i % k == 0:
                left[i] = nums[i]
            else:
                left[i] = max(nums[i], left[i-1])
            j = n - i -1
            if (j + 1) % k == 0:
                right[j] = nums[j]
            else:
                right[j] = max(nums[j], right[j+1])
        res = []
        for i in range(n-k+1):
            res.append(max(left[i+k-1], right[i]))
        return res