int findSize(struct TreeNode* root){
    if(root == NULL) return 0;
    return findSize(root->left) + findSize(root->right) + 1;
}

void recurseTravel(struct TreeNode* root, int* ans, int* t){
    if(root != NULL){
        if(root->left != NULL){
          recurseTravel(root->left,ans,t);
        }
        ans[*t] = root->val;
        t[0] ++ ;

        if(root->right != NULL){
            recurseTravel(root->right,ans,t);
        }
    }
}

int* inorderTraversal(struct TreeNode* root, int* returnSize){
    int *ans;
    int *pointer = (int *)malloc(sizeof(int));
    pointer[0] = 0;
    *returnSize = findSize(root);
    ans = (int*) malloc(sizeof(int)*(*returnSize));

    printf("size:%d\n",*returnSize);
    recurseTravel(root,ans,pointer);

    return ans;
}