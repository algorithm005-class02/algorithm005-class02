class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> ret;
        while(root != NULL) {
            if(root->left == NULL) {
                ret.push_back(root->val);
                root = root->right;
            } else {
                TreeNode* preDes = getPredessesor(root);
                if(preDes->right == root) {
                    preDes->right = NULL;
                    root = root->right;
                } else {
                    ret.push_back(root->val);
                    preDes->right = root;
                    root = root->left;
                }
            }
        }
        return ret;
    }
private:
    TreeNode* getPredessesor(TreeNode* root){
        TreeNode* left = root->left;
        while(left != NULL && left->right != NULL && left->right != root) {
            left = left->right;
        }
        return left;
    }
};
