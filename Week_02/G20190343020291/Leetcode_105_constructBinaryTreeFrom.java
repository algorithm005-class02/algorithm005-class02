import java.util.HashMap;
import java.util.Map;

/**
 * 从前序和中序遍历序列构造二叉树
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Leetcode_105_constructBinaryTreeFrom {

    /**
     * 方法1： 先序遍历
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }


    private TreeNode helper(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }

        int index = 0;
        for (int i = iStart; i <= iEnd; i++) {
            if (preorder[pStart] == inorder[i]) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(inorder[index]);
        root.left = helper(preorder, inorder, pStart + 1, pStart + index - iStart, iStart, index - 1);
        root.right = helper(preorder, inorder, pStart + index - iStart + 1, pEnd, index + 1, iEnd);

        return root;
    }


    /**
     * 方法2： 查询的过程用Map替代，空间换时间
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return helper(preorder, inorder, 0, preorder.length - 1,  0, inorder.length - 1, inMap);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int pStart, int pEnd,  int iStart, int iEnd, Map<Integer, Integer> inMap) {
        if (pStart > pEnd) {
            return null;
        }

        int index = inMap.get(preorder[pStart]);
        TreeNode root = new TreeNode(inorder[index]);

        root.left = helper(preorder, inorder, pStart + 1, pStart + index - iStart, iStart, index - 1, inMap);
        root.right = helper(preorder, inorder, pStart + index - iStart + 1, pEnd, index + 1, iEnd, inMap);

        return root;
    }
}
