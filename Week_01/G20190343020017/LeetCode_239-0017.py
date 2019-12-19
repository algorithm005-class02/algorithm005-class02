class Solution:
    def maxSlidingWindow(self, nums, k):
        # 方法一：暴力法
        '''
        if not nums or not k:
            return []
        maxs = []
        for i in range(len(nums) - k + 1):
            maxs.append(max(nums[i:i+k]))
        return maxs
        '''
        # 方法二：队列法
        if not nums or not k:
            return []
        deque, result = [], []
        # 先放入前k个
        for i in range(k):
            while deque and nums[deque[-1]] <= nums[i]:
                deque.pop()
            deque.append(i)
        result.append(nums[deque[0]])
        # 循环向后滑动
        for i in range(k, len(nums)):
            while deque and deque[0] <= i - k:
                deque.pop(0)
            while deque and nums[deque[-1]] <= nums[i]:
                deque.pop()
            deque.append(i)
            result.append(nums[deque[0]])
        return result