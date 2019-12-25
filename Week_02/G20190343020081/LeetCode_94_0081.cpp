class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
       vector<int> ret;
       while(root) {
           if(root->left == NULL) {
               ret.push_back(root->val);
               root = root->right;
           } else {
               TreeNode* preDes = getPredessesor(root);
               if(preDes->right == root) {
                   ret.push_back(root->val);
                   preDes->right = NULL;
                   root = root->right;
               } else {
                   preDes->right = root;
                   root = root->left;
               }
           }
       }
       return ret;
    }
private:
    TreeNode* getPredessesor(TreeNode* root) {
       TreeNode* left = root->left;
       while(left  != NULL && left->right != NULL && left->right != root)
            left = left->right;
        return left;
    }
};
