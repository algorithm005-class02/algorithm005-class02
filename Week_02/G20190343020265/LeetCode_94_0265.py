#
# @lc app=leetcode.cn id=94 lang=python3
#
# [94] 二叉树的中序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 解法一，采用递归的方式求解二叉树的中序遍历
# 首先，定义二叉树的节点类 TreeNode，其中有三个属性val、left、right
# 分别为节点值、左子树、右子树
# 中序遍历的顺序是左根右，即左子树->根节点->右子树，代码上就是先递归调用
# root.left左子树，同理中序遍历左子树，弹出后获取根节点值，然后递归调用
# root.right右子树，同理中序遍历右子树，结束
# class Solution:
#     def inorderTraversal(self, root: TreeNode) -> List[int]:
#         res = []
#         def helper(root):
#             if not root:
#                 return
#             helper(root.left)
#             res.append(root.val)
#             helper(root.right)
#         helper(root)
#         return res
        
# 解法二，利用栈数据结构的迭代解法，依次将数据压入，然后按后进先出的方式取出数据
# 先将左子树压入栈中，然后依次出栈，结果数组记录出栈节点值，然后再看右子树，
# 同理也是先遍历右子树中子左子树，然后查看子右子树，直到遍历完成
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        stack = []
        p = root
        while p or stack:
            while p:
                stack.append(p)
                p = p.left
            p = stack.pop()
            res.append(p.val)
            p = p.right
        return res

# @lc code=end

