学习笔记

# 递归函数思路
1. terminator
2. process logic
3. drill down
4. reverse status if needed

## 注意事项
1. 切记人肉递归
2. 寻找重复子问题
3. 数学归纳法

# 二叉树的遍历递归
```cpp
    // 前序遍历
    void preorderTraversalCur(TreeNode* root, vector<int>& res) {
        //terminator
       if (!root) return;
        //process
        res.push_back(root->val);
        //drill down
        preorderTraversalCur(root->left, res);
        preorderTraversalCur(root->right, res);
        //reverse
    }
    // 中序遍历
    void preorderTraversalCur(TreeNode* root, vector<int>& res) {
       if (!root) return;
        preorderTraversalCur(root->left, res);
        res.push_back(root->val);
        preorderTraversalCur(root->right, res);
    }
     // 后序遍历
    void preorderTraversalCur(TreeNode* root, vector<int>& res) {
       if (!root) return;
        preorderTraversalCur(root->left, res);
        preorderTraversalCur(root->right, res);
        res.push_back(root->val);
    }
```