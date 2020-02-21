#
# @lc app=leetcode.cn id=120 lang=python3
#
# [120] 三角形最小路径和
#

# @lc code=start
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if not triangle:
            return
        # for i in range(1, len(triangle)+1):
        #     for j in range(len(triangle[i])):
        #         if j == 0:
        #             triangle[i][j] += triangle[i-1][j]
        #         elif j == len(triangle[i])-1:
        #              triangle[i][j] += triangle[i-1][j-1]
        #         else:
        #             triangle[i][j] += min(triangle[i-1][j-1], triangle[i-1][j])
        # return min(triangle[-1])
        # f[i,j] = min(f[i+1][j+1], f[i+1][j]) + a[i][j]
        for i in range(len(triangle)-2,-1,-1):
            for j in range(len(triangle[i])):
                triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1])
        return triangle[0][0]
# @lc code=end

