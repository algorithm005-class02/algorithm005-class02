/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct TreeNode* lowestCommonAncestor(struct TreeNode* root, struct TreeNode* p, struct TreeNode* q) {
   if (root == p || root == q || !root)
     return root;

   struct TreeNode *left  = lowestCommonAncestor(root->left, p, q);
   struct TreeNode *right = lowestCommonAncestor(root->right, p, q);

   if (!left && !right) 
     return NULL;
   else if (left &&  !right)
     return left;
   else if (right && !left)
     return right;

   return root;  
}
