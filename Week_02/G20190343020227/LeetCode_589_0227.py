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
    def preorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        res = []
        def helper(root):
            if not root:
                return
            res.append(root.val)
            for i in root.children:
                helper(i)
        helper(root)
        return res