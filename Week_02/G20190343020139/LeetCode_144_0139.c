/**
 * Note: The returned array must be malloced, assume caller calls free().
 * Accepted
 * 68/68 cases passed (8 ms)
 * Your runtime beats 8.68 % of c submissions
 * Your memory usage beats 99.14 % of c submissions (7.2 MB)
 */
int findSize(struct TreeNode* root){
    if(root == NULL) return 0;
    return findSize(root->left) + findSize(root->right) + 1;
}

void recurseTravel(struct TreeNode* root, int* ans, int* t){
    if(root != NULL){

        ans[*t] = root->val;
        t[0] ++ ;
        if(root->left != NULL){
          recurseTravel(root->left,ans,t);
        }
        if(root->right != NULL){
            recurseTravel(root->right,ans,t);
        }
    }
}

int* preorderTraversal(struct TreeNode* root, int* returnSize){
    int *ans;
    int *pointer = (int *)malloc(sizeof(int));
    pointer[0] = 0;
    *returnSize = findSize(root);
    ans = (int*) malloc(sizeof(int)*(*returnSize));

    printf("size:%d\n",*returnSize);
    recurseTravel(root,ans,pointer);

    return ans;
}