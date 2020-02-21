class Solution:
    def maxArea(self, height):
        result = []
        self._generate_area(result, 0, len(height) - 1, height)
        return max(result)

    def _generate_area(self, result, left, right, height):
        if left == right:
            return
        result.append(result, (right - left) * min(height[right], height[left]))
        if height[left] > height[right]:
            self._generate_area(result, left, right - 1, height)
        else:
            self._generate_area(result, left + 1, right, height)

    def maxArea_loop(self, height):
        result, left, right = 0, 0, len(height) - 1
        while left < right:
            if height[right] > height[left]:
                result = max(result, (right - left) * height[left])
                left += 1
            else:
                result = max(result, (right - left) * height[right])
                right -= 1
        return result







