#!/usr/bin/python
# -*- coding: UTF-8 -*-
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        res = []
        if not root:
            return res
        def helper(node,lever,res):#子节点，深度，存储栈
            lever += 1  #每次递归，深度加1
            if (len(res) - 1 < lever):
                res.append([]) #创建一个空栈存储遍历的子节点
            for i in node:  #遍历孩子节点
                res[lever].append(i.val)
                if i.children is not None: #如果子节点还有子节点，递归调用
                    helper(i.children,lever,res)
        res.append([root.val]) #记录第一个祖先节点，深度为0
        helper(root.children,0,res)
        res.pop() #去除最后一个多余列表
        return res