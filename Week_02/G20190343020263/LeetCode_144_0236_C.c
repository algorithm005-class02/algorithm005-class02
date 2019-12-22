/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

int TreeSize (struct TreeNode *root)
{
  if (root == NULL)
    return 0;

  return TreeSize(root->left) + TreeSize(root->right) + 1;

}

void preorder(struct TreeNode *root, int* returnSize, int *res)
{
  if(root == NULL)
    return;
  
  res[(*returnSize)++] = root->val;
  preorder(root->left, returnSize, res);
  preorder(root->right, returnSize, res);

}

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* preorderTraversal(struct TreeNode* root, int* returnSize){
   int NodeCount;
   int *res;

   NodeCount = TreeSize(root);

   res = malloc(sizeof(int) * NodeCount);
   
   *returnSize = 0;
   preorder(root, returnSize, res);

   return res;
}
