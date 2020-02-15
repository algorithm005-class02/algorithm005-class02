# -*- encoding: utf-8 -*-
# Create by zq
# Create on 2020/2/15

class Solution:
    def minCostClimbingStairs(self, cost):
        f0 = f1 = 0
        for i in range(len(cost)):
            f0, f1 = f1, cost[i] + min(f0, f1)
        return min(f0, f1)

if __name__ == '__main__':
    test = Solution()
    print(test.minCostClimbingStairs([10, 15, 20])) #15
    print(test.minCostClimbingStairs([0,2,2,1])) #2
    print(test.minCostClimbingStairs([1, 100, 1, 1, 1, 100, 1, 1, 100, 1])) #6