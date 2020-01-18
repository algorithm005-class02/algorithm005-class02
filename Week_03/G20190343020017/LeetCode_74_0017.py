# 纯暴力查询
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        for span in matrix:
            for num in span:
                if num == target:
                    return True
        return False

# 暴力确定范围 + 暴力搜索
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        for span in matrix:
            # 确定范围
            if span and span[0] <= target and span[-1] >= target:
                # 寻找目标
                for num in span:
                    if num == target:
                        return True
                # 避免其他范围无用搜索
                break
        return False

# 暴力确定范围 + 二分查找
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        for span in matrix:
            # 确定范围
            if span and span[0] <= target and span[-1] >= target:
                # 寻找目标
                left, right = 0, len(span) - 1
                while left <= right:
                    mid = left + (right - left) // 2
                    if span[mid] == target:
                        return True
                    elif span[mid] < target:
                        left = mid + 1
                    else:
                        right = mid - 1
                break
        return False

# 二分确定范围 + 二分查询目标
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        leftSpan, rightSpan = 0, len(matrix) - 1
        while leftSpan <= rightSpan:
            midSpan = leftSpan + (rightSpan - leftSpan) // 2
            span = matrix[midSpan]
            if not span:
                return False
            if span[0] <= target and span[-1] >= target:
                # 寻找目标
                left, right = 0, len(span) - 1
                while left <= right:
                    mid = left + (right - left) // 2
                    if span[mid] == target:
                        return True
                    elif span[mid] < target:
                        left = mid + 1
                    else:
                        right = mid - 1
                return False
            elif span[0] > target:
                rightSpan = midSpan - 1
            else:
                leftSpan = midSpan + 1
        return False