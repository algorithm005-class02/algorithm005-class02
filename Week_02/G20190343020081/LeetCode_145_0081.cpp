class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> ret;
        TreeNode* head = root;
        while (root) {
            if (root->left == NULL) {
                root = root->right;
            } else {
                TreeNode* preDes = getPredessesor(root);
                if (preDes->right == root) {
                    preDes->right = NULL;
                    printReverse(root->left, ret);
                    root = root->right;
                } else {
                    preDes->right = root;
                    root = root->left;
                }
            }
        }
        printReverse(head, ret);
        return ret;
    }
private:
    TreeNode* getPredessesor(TreeNode* root) {
        TreeNode* left = root->left;
        while (left != NULL && left->right != NULL && left->right != root) {
            left = left->right;
        }
        return left;
    }
  
    void printReverse(TreeNode* root, vector<int>& ret) {
        if (root == NULL) return;
        TreeNode* tail = reverseRight(root);
        TreeNode* node = tail;
        while (node != NULL) {
            ret.push_back(node->val);
            node = node->right;
        }
        reverseRight(tail);
    }

    TreeNode* reverseRight(TreeNode* root) {
        TreeNode* prev = root;
        TreeNode* curr = prev->right;
        prev->right = NULL;
        while (curr != NULL) {
            TreeNode* temp = curr->right;
            curr->right = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    } 
};
