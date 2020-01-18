#
# @lc app=leetcode.cn id=105 lang=python3
#
# [105] 从前序与中序遍历序列构造二叉树
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 相关知识点
# 如何遍历一棵树
# 有两种通用的遍历树的策略：
# 宽度优先搜索（BFS）
# 我们按照高度顺序一层一层的访问整棵树，高层次的节点将会比低层次的节点先被访问到。
# 深度优先搜索（DFS）
# 在这个策略中，我们采用深度作为优先级，以便从跟开始一直到达某个确定的叶子，然后再返回根到达另一个分支。
# 深度优先搜索策略又可以根据根节点、左孩子和右孩子的相对顺序被细分为前序遍历，中序遍历和后序遍历。

# 解法一， 递归解法
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        def helper(in_left = 0, in_right = len(inorder)):
            nonlocal pre_index
            # 终止条件
            if in_left == in_right:
                return None
            # 处理过程
            root_val = preorder[pre_index]
            root = TreeNode(root_val)
            index = idx_map[root_val]
            pre_index += 1
            # 下一层
            root.left = helper(in_left, index)
            root.right = helper(index + 1, in_right)
            return root
        # 初始化，从前序的第一个元素开始
        pre_index = 0
        # 建立idx_map函数，从值到值所在索引的映射
        idx_map = {val:idx for idx, val in enumerate(inorder)}
        return helper()

        
# @lc code=end

