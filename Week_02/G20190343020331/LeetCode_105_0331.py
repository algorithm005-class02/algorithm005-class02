#!/usr/bin/env python3
# -*-coding:utf-8-*-


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if not preorder or not inorder:
            return None

        root = TreeNode(preorder[0])
        root.left = self.buildTree(
            preorder[1:inorder.index(root.val) + 1], inorder[0:inorder.index(root.val)]
        )
        root.right = self.buildTree(
            preorder[inorder.index(root.val) + 1:], inorder[inorder.index(root.val) + 1:]
        )
        return root
