<?php

// 从中序与后序遍历序列构造二叉树
// url https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

// Definition for a binary tree node.
class TreeNode
{
    public $val = null;
    public $left = null;
    public $right = null;

    function __construct($value)
    {
        $this->val = $value;
    }
}

class Solution
{

    /**
     * @param Integer[] $inorder
     * @param Integer[] $postorder
     * @return TreeNode
     */
    function buildTree($inorder, $postorder)
    {
        return $this->helper($postorder, 0, count($postorder) - 1, $inorder, 0, count($inorder) - 1);
    }

    private function helper($postorder, $pStart, $pEnd, $inorder, $iStart, $iEnd)
    {
        if ($pStart < 0 || $iStart > $iEnd) return null;
        $root = new TreeNode($postorder[$pEnd]);
        $key = array_search($root->val, $inorder);

        $postorderStartLeft = $pStart + $key - $iStart;
        $postorderStartRight = $pStart + $key - $iStart - 1;

        $root->left = $this->helper($postorder, $pStart, $postorderStartRight, $inorder, $iStart, $key - 1);
        $root->right = $this->helper($postorder, $postorderStartLeft, $pEnd - 1, $inorder, $key + 1, $iEnd);
        return $root;
    }
}

$inorder = [9, 3, 15, 20, 7];
$postorder = [9, 15, 7, 20, 3];
$Solution = new Solution();
print_r($Solution->buildTree($inorder, $postorder));