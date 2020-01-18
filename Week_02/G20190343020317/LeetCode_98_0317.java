class Solution{
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    public boolean helper(TreeNode cur, Integer bot, Integer top) {
        if (cur == null) {
            return true;
        }
        if (top != null && top <= cur.val) {
            return false;
        }
        if (bot != null && bot >= cur.val) {
            return false;
        }
        return helper(cur.left, bot, cur.val) && helper(cur.right, cur.val, top);
    }
}