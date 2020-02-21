package leetcode.week02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的中序遍历
 *题目描述： 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 */
public class LeetCode_94_0069 {

    /**
     * main
     * @param args
     */
    public static void main (String args[]) {
        //test cases
        String input = "[1,null,2,3]"; //Expected 1 3 2
        //create TreeNode
        TreeNode root = stringToTreeNode(input);
        //inorder traversal
        List<Integer> res = inorderTraversal(root);
        //print out
        for (int item : res) {
            System.out.print(item + " ");
        }
    }

    /**
     * create TreeNode
     * @param input
     * @return
     */
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    /**
     * recursion main
     * @param root
     * @return
     */
    private static List<Integer> inorderTraversal (TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        recursion(root , res);
        return res;
    }

    /**
     * solution 1：recursion
     *
     * code template:
     * terminator
     * process current logic
     * drill down
     */
    private static void recursion (TreeNode root , List<Integer> res) {
        //terminator
        if (null != root) {
            if (root.left != null) {
                //drill down
                recursion(root.left , res);
            }
            //process current logic
            res.add(root.val);
            if (root.right != null) {
                //drill down
                recursion(root.right ,res);
            }
        }
    }
}


