class Solution:
    def largestRectangleArea_divide_conquer(self, heights):
        """分治，超时，分治的优化，线段树，看球不懂"""
        if not heights:
            return 0

        def calculate_area(current_heights, max_value):
            i = 0
            current_len = len(current_heights)
            min_value = min(current_heights)
            current_max_value = max(max_value, min_value * current_len)
            min_index = current_heights.index(min_value)
            if min_index - 1 >= 0:
                current_max_value = max(current_max_value,
                                calculate_area(current_heights[:min_index],
                                               current_max_value))
            if min_index + 1 <= current_len - 1:
                current_max_value = max(current_max_value,
                                calculate_area(current_heights[min_index + 1:],
                                               current_max_value))
            return current_max_value

        return calculate_area(heights, 0)

    def largestRectangleArea_stack(self, heights):
        if not heights:
            return 0
        max_area = 0
        index_stack = [-1, 0]
        len_heights = len(heights)
        i = 1
        while i < len_heights:
            if heights[i] < heights[index_stack[-1]]:
                while index_stack[-1] != -1 and heights[i] < heights[index_stack[-1]]:
                    max_area = max(max_area, heights[index_stack.pop()] * (i - index_stack[-1] - 1))
                index_stack.append(i)
            else:
                index_stack.append(i)
            i += 1

        while index_stack[-1] != -1:
            max_area = max(max_area, heights[index_stack.pop()] * (len_heights - 1 - index_stack[-1]))

        return max_area

    def largestRectangleArea(self, height):
        height.append(0)
        stack = [-1]
        ans = 0
        for i in range(len(height)):
            while height[i] < height[stack[-1]]:
                h = height[stack.pop()]
                w = i - stack[-1] - 1
                ans = max(ans, h * w)
            stack.append(i)
        height.pop()
        return ans


if __name__ == '__main__':
    test = Solution()
    
    print(test.largestRectangleArea([2, 1, 5, 6, 2, 3]))  # 10
    print(test.largestRectangleArea([2, 1, 5, 5, 6, 2, 3]))  # 15
    print(test.largestRectangleArea([2, 1, 2]))  # 3
    print(test.largestRectangleArea([2, 2]))  # 4
    print(test.largestRectangleArea([4, 2, 0, 3, 2, 4, 3, 4]))  # 10
    print(test.largestRectangleArea([]))  # 0
    print(test.largestRectangleArea([10]))  # 10
