class Solution(object):
    def plusOne(self, digits):
        sums = 0
        for i in digits:
            sums = sums * 10 + i 
        sums_str = str(sums + 1)
        return [j for j in sums_str]