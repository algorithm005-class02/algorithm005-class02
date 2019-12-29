<?php

// 二叉树的中序遍历
/**
 *  前序遍历 根-左-右
 *  中序遍历 左-根-右
 *  后序遍历 左-右-根
 */

/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */
class Solution
{
    /**
     * @param TreeNode $root
     * @return Integer[]
     */
    public $res = [];

    function inorderTraversal($root)
    {
        if ($root != null) {
            $this->inorderTraversal($root->left);
            $this->res[] = $root->val;
            $this->inorderTraversal($root->right);
        }
        return $this->res;
    }
}