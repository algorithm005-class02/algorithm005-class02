#
# @lc app=leetcode.cn id=120 lang=python3
#
# [120] 三角形最小路径和
# 采用从下往上的递推解法
# 递推公式是当前位置的数值等于下一行相同列、相同列+1的两个数值的最小值
# 加上当前位置的数值，一直递推到最上面就是金字塔顶端，为题目所需的解
# 这里采用了 triangle_tmp 是属于函数内的局部变量，为的是不改变传参
# 进来的triangle的值，更改传参内容这在工业代码里是个坑，需要注意


# @lc code=start
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if not triangle:
            return
        triangle_tmp = triangle
        for i in range(len(triangle_tmp)-2, -1, -1):
            for j in range(len(triangle_tmp[i])):
                triangle_tmp[i][j] += min(triangle_tmp[i+1][j], triangle_tmp[i+1][j+1])
        return triangle_tmp[0][0]


# @lc code=end

