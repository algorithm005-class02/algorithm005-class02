class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        count = [0] * 21
        for money in bills:
            count[money], change = count[money] + 1, money - 5
            if change > 10 and count[10]:
                change, count[10] = change - 10, count[10] - 1
            while change > 0 and count[5]:
                change, count[5] = change - 5, count[5] - 1
            if change >0:
                return False
        return True