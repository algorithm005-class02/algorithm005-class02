struct TreeNode* getChildNode(int* pre, int preSize, int* ino, int inSize) {
    if (preSize == 0) {
        return NULL;
    }
    struct TreeNode* node = malloc(sizeof(struct TreeNode));
    for (int i = 0; i < preSize; i++) {
        if (ino[i] == pre[0]) {
            node -> val = pre[0];
            node -> left = getChildNode (pre + 1, i, ino, i);
            node -> right = getChildNode (pre + 1 + i, preSize - i -1, ino + i + 1, inSize - i - 1);
            break;
        }
    }
    return node;
}
struct TreeNode* buildTree(int* preorder, int preorderSize, int* inorder, int inorderSize){
    return getChildNode(preorder, preorderSize, inorder, inorderSize);
}