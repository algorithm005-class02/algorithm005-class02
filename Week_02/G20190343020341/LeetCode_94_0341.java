import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_94_0341 {

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            List<Integer> leftList = getLeftChildValue(root.left);
            if (leftList != null) {
                list.addAll(leftList);
            }
            list.add(root.val);
            List<Integer> rightList = getLeftChildValue(root.right);
            if (rightList != null) {
                list.addAll(rightList);
            }
        }
        return list;
    }

    private List<Integer> getLeftChildValue(TreeNode root) {
        if (root != null) {
            return inorderTraversal(root);
        } else {
            return null;
        }
    }

    private List<Integer> getRightChildValue(TreeNode root) {
        if (root != null) {
            return inorderTraversal(root);
        } else {
            return null;
        }
    }
}
