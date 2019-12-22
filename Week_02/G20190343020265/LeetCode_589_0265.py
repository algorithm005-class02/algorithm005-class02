#
# @lc app=leetcode.cn id=589 lang=python3
#
# [589] N叉树的前序遍历
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

# 再码一遍
# 解法一，递归遍历方法，前序遍历的顺序是根节点->从左到右的子节点
# 这里有个记忆前序、中序、后序遍历的方法，我只需要记住根节点在那个位置就可以
# 比如根节点在前面就是前序遍历，根节点在中间就是中序，根节点在最后就是后序遍历
# 而子节点的顺序一直都是从左到右的方式
# class Solution:
#     def preorder(self, root: 'Node') -> List[int]:
#         res = []
#         def helper(root):
#             if not root:
#                 return
#             res.append(root.val)
#             for i in root.children:
#                 helper(i)
#         helper(root)
#         return res
        
# 解法二，迭代解法
# 码多了，就认识更深刻一些，也更清晰一些，递归如果数学归纳法。而迭代，不调用自己，利用栈
# 数据结构得到想要的顺序，那么，以后在工程中怎么取考量用哪种方法呢？
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if not root:
            return
        stack, res = [root], []
        while stack:
            node = stack.pop()
            res.append(node.val)
            stack.extend(node.children[::-1])
        return res

# 顺道记录下 python函数 append() 与 extend() 的区别
# list.extend() 把一个序列seq的内容添加到列表中，list.append() 向列表中添加一个对象
# extend若为列表将列表元素，在尾部逐一加入，若为字典是将字典key值，在尾部逐一加入
# append是将整个对象在末尾加入
# 如解法二 迭代解法遍历子节点代码： for i in node.children[::-1]: stack.append(i)
# 可以修改为：stack.extend(node.children[::-1])
# 相对来说代码整体会显得更加的整洁

# @lc code=end

