# -*- encoding: utf-8 -*-
# Create on 2020/2/16

class Solution:
    def numJewelsInStones_1(self, J, S):
        res = 0
        for i in J:
            if i in S:
                res += S.count(i)
        return res

    def numJewelsInStones_2(self, J, S):
        return sum(s in J for s in S)

    def numJewelsInStones(self, J, S):
        return sum(map(J.count, S))

if __name__ == '__main__':
    test = Solution()
    print(test.numJewelsInStones("aA", "aAAbbbb")) #3
    print(test.numJewelsInStones("z", "ZZ")) #0
