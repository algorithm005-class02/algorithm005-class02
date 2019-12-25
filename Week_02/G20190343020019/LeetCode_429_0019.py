#
# @lc app=leetcode.cn id=429 lang=python3
#
# [429] N叉树的层序遍历
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        # 1. 标记法
        # res, stack = [], root and [(root, 0)]
        # while stack:
        #     node, level = stack.pop()
        #     if level == len(res):
        #         res.append([node.val])
        #     else:
        #         res[level].append(node.val)
        #     for i in node.children[::-1]:
        #         stack.append((i, level + 1))
        # return res

        # 2. BFS
        res, queue = [], root and [root]
        while queue:
            # ans, children = [], []
            # for i in queue:
            #     ans.append(i.val)
            #     if i.children: children.extend(i.children)
            # queue = children
            # res.append(ans)

            # list 生成器写法
            res.append([node.val for node in queue])
            queue = [child for node in queue for child in node.children if child]
        return res
        
# @lc code=end

