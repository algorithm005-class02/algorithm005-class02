class Solution:
    # 递归回溯
    def combine(self, n: int, k: int) -> List[List[int]]:
        result = []
        self._combine(n, 0, k, [], result)
        return result

    def _combine(self, n, start, k, l, result):
        # terminator
        if k == 0:
            result.append(l)
            return
        if start + k > n:
            return
        
        # process and drill down
        for i in range(start, n):
            self._combine(n, i + 1, k - 1, l + [i + 1], result)
        
    # 题解字典法
    def combine(self, n: int, k: int) -> List[List[int]]:
        nums, result, gap = list(range(1, k + 1)) + [n + 1], [], 0
        while gap < k:
            result.append(nums[:k])
            gap = 0
            while gap < k and nums[gap] + 1 == nums[gap + 1]:
                nums[gap], gap = gap + 1, gap + 1
            nums[gap] += 1
        return result