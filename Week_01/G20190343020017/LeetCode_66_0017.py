class Solution:
    # 1.课前尝试解题（之前已经做过这个题目看过题解）
    def plusOne(self, digits: List[int]) -> List[int]:
        # 先在末位+1
        digits[-1] += 1
        # 循环遍历检查是否需要进一
        for i in range(len(digits))[::-1]:
            if digits[i] > 9:
                digits[i] = 0
                if i == 0:
                    digits.insert(0, 1)
                else:
                    digits[i - 1] += 1
        return digits