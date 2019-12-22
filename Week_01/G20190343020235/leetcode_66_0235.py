"""
思路 1：
pythonic 解法，化为 str-->int-->int+1-->str-->array
思路 2:
因为只是+1，所以只有当该位置为 9 的时候，才有可能进位，所以我们可以从后往前遍历，如果是 9，那么该位就为 0，否则就+1，如果最后遍历完整个数组，那么说明首位有进位，需要插入一个 1
"""

#思路 1 24ms 12.7mb
class Solution1:
    def plusOne(self, digits: List[int]) -> List[int]:
        if not digits:
            return 0
        return [int(c) for c in str(int(''.join(map(lambda x: str(x), digits)))+1)]
#思路 2 28ms 12.9mb
class Solution2:
    def plusOne(self, digits: List[int]) -> List[int]:
        if not digits:
            return 0
        for i in range(len(digits)-1, -1, -1):
            digits[i] = digits[i] + 1 if digits[i] < 9 else 0
            if digits[i]:
                return digits
        digits.insert(0, 1)
        return digits
        
        