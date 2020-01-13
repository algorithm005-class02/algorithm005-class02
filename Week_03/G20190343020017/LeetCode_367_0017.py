class Solution:
    # 二分法
    def isPerfectSquare(self, num: int) -> bool:
        if num == 0 or num == 1 or num == 4:
            return True
        elif num < 9:
            return False
        left, right = 3, num // 2
        while left <= right:
            mid = left + (right - left) // 2
            sqr = mid * mid
            if sqr == num:
                return True
            elif sqr > num:
                right = mid - 1
            else:
                left = mid + 1
        return False