
int find_root(int* inorder,int inorderSize,int rootVal) {
    for (int cnt = 0; cnt < inorderSize; ++cnt) {
        if (inorder[cnt] == rootVal) {
            return cnt;
        }
    }
    return -1;
}

struct TreeNode* buildTree(int* preorder, int preorderSize, int* inorder, int inorderSize){
    if (!preorder || !inorder || !preorderSize || !inorderSize) {
        return NULL;
    }
    struct TreeNode* root = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    root->val = preorder[0];
    int rootPos = find_root(inorder,inorderSize,preorder[0]);
    root->left = buildTree(preorder+1, rootPos, inorder, rootPos);
    root->right = buildTree(preorder+1+rootPos, inorderSize-rootPos-1, inorder+rootPos+1, inorderSize-rootPos-1);

    return root;
}

