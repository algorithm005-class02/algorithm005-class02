#
# @lc app=leetcode.cn id=102 lang=python3
#
# [102] 二叉树的层次遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 层序遍历，采用广度优先遍历 BFS， 核心算法逻辑如下：
# 设置两个列表空间
# 一个是当前层 cur_level，用于遍历当前层，其中用temp放置当前层遍历得到的元素，
# 另一个next_level放置下一层准备遍历的元素
# 迭代直至cur_level当前层为空
# 这里需要深挖下术语：迭代、递归 的异同点，加深对算法中使用到迭代、递归部分的理解

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return 
        cur_level, res = [root], []
        while cur_level:
            temp = []
            next_level = []
            for node in cur_level:
                temp.append(node.val)
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)
            res.append(temp)
            cur_level = next_level
        return res
   
# @lc code=end

