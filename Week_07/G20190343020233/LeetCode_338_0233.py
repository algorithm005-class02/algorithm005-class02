# -*- encoding: utf-8 -*-
# Create by zq
# Create on 2020/2/9

class Solution:
    def countBits_bit(self, num):
        result = []
        for i in range(num+1):
            res = 0
            while i != 0:
                res += 1
                i &= i - 1
            result.append(res)
        return result

    def countBits(self, num):
        result = []
        for i in range(num+1):
            result.append(bin(i).count("1"))
        return result


if __name__ == '__main__':
    test = Solution()
    print(test.countBits(2)) # [0, 1, 1]
    print(test.countBits(5)) # [0, 1, 1, 2, 1, 2]
