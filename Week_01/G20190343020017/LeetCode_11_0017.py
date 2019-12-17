class Solution:
    def maxArea(self, height: List[int]) -> int:
        # 方法一：暴力枚举法（测试用例通过，提交运行超时）
        '''
        _maxArea = 0
        for i in range(len(height)):
            for j in range(i+1, len(height)):
                area = min(height[i], height[j]) * (j - i)
                _maxArea = max(_maxArea, area)
        return _maxArea
        '''
        # 方法二 收敛法（144ms）
        _maxArea, i, j, hei = 0, 0, len(height) - 1, 0
        while i < j:
            if height[i] < height[j]:
                hei = height[i]
                i += 1
            else:
                hei = height[j]
                j -= 1
            _maxArea = max(_maxArea, (j - i + 1) * hei)
        return _maxArea