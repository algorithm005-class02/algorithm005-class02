/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

int TreeNodeLength (struct TreeNode *root)
{
  if (root == NULL)
    return 0;
  
  return TreeNodeLength(root->left) + TreeNodeLength(root->right) + 1;

}

void inorder (struct TreeNode *root, int *res, int *NodeIndex)
{
  if (root == NULL)
    return;
  inorder (root->left, res, NodeIndex);
  res[(*NodeIndex)++] = root->val;
  inorder (root->right, res, NodeIndex);
}
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* inorderTraversal(struct TreeNode* root, int* returnSize){
  int NodeCnt;
  int *res;
  
  NodeCnt = TreeNodeLength(root);
  res = malloc(sizeof(int) * NodeCnt);

  *returnSize = 0;
  inorder(root, res, returnSize);

  return res;
  
}
