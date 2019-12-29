#
# @lc app=leetcode.cn id=590 lang=python3
#
# [590] N叉树的后序遍历
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
# 解法一，采用迭代的方式，N叉树的迭代解法和二叉树基本逻辑是一致的，后序遍历是从左到右
# 的子树->根节点，在迭代解法中，会从根节点->从右到左子树的方式遍历，最后倒序输出
# 这里依然是采用栈的数据结构，后进先出的逻辑，所以会让右边子树先出栈（即右边后进栈）
# class Solution:
#     def postorder(self, root: 'Node') -> List[int]:
#         if root is None:
#             return []
#         stack, res = [root], []
#         while stack:
#             node = stack.pop()
#             res.append(node.val)
#             for i in node.children:
#                 stack.append(i)
#         return res[::-1]

# 解法二，递归解法， 顺序是左、右、根节点，与二叉树不同点在于：二叉树是固定左右两个子节点
# 依次遍历即可；而N叉树是不定子节点，加一个循环遍历即可
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        res = []
        def helper(root):
            if not root:
                return
            for i in root.children:
                helper(i)
            res.append(root.val)
        helper(root)
        return res

# @lc code=end

