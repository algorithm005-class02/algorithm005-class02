void preorderTraversalFun(struct TreeNode* root, int* returnSize, int* returnArray){
    if (root == NULL) { return; }
    returnArray[(*returnSize)++] = root->val;
    preorderTraversalFun(root->left, returnSize, returnArray);
    preorderTraversalFun(root->right, returnSize, returnArray);
}

int* preorderTraversal(struct TreeNode* root, int* returnSize){
    *returnSize = 0;
    int* returnArray = (int*)malloc(sizeof(int)*100);
    preorderTraversalFun(root, returnSize, returnArray);
    return returnArray;
}
