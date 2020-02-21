void inorderTraversalFun(struct TreeNode* root, int* returnSize, int* returnArray){
    if (root == NULL) { return; }
    inorderTraversalFun(root->left, returnSize, returnArray);
    returnArray[(*returnSize)++] = root->val;
    inorderTraversalFun(root->right, returnSize, returnArray);
}
int* inorderTraversal(struct TreeNode* root, int* returnSize){
    int *returnArray = (int*)malloc(sizeof(int)*100);
    *returnSize = 0;
    inorderTraversalFun(root, returnSize, returnArray);
    return returnArray;
}
