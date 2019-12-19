class Solution:
    def plusOne(self, digits):
        num = 0
        for i in digits:
            num = num * 10 + i

        num += 1
        output = []

        while num:
            temp = num % 10
            num //= 10
            output.append(temp)

        return output[::-1]
