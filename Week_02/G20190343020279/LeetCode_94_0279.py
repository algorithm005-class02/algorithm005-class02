"""
 @method "颜色标记法"
 @explain 兼具栈迭代方法的高效，又像递归方法一样简洁易懂，更重要的是，这种方法对于前序、中序、后序遍历，能够写出完全一致的代码。1.使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。2.如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈。3.如果遇到的节点为灰色，则将节点的值输出。
 @complexity 时间复杂度：O(n) ,空间复杂度：O(n)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        # 1.设定白灰两色
        WHITE,GRAY = 0,1
        # 2.用于返回结果的数组
        res = []
        # 3.维护一个带颜色属性的节点栈
        stack = [(WHITE,root)]
        while stack:
            # 4.每次遍历都会出栈一个节点
            color,node = stack.pop()
            if node is None:continue
            # 5.重点：根据栈先入后出，所以是右-根-左反过来写
            if color == WHITE:
                stack.append((WHITE,node.right))
                stack.append((GRAY,node))
                stack.append((WHITE,node.left))
            # 6.遇到灰节点输出
            else:
                res.append(node.val)
        return res
