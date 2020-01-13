/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        return pathSumSub(root, sum, new int[1000], 0);
    }

    public int pathSumSub(TreeNode root, int sum, int[] arr,int p) {
        if(root == null) {
            return 0;
        }
        int tmp = root.val;
        int n = sum == tmp ? 1 : 0;
        for(int i = p - 1;i >= 0;i--) {
            tmp += arr[i];
            if(tmp == sum) {
                n++;
            }
        }
        arr[p] = root.val;
        int n1 = pathSumSub(root.left,sum, arr, p+1);
        int n2 = pathSumSub(root.right,sum,arr,p+1);
        return n+n1+n2;
    }
}