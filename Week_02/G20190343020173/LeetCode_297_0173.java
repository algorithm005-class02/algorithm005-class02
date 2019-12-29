package org.crayzer.leetcode.editor.en.treez_recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_297_SerializeAndDeserializeBinaryTree {

    private final static String SEPARATOR = ",";
    private final static String NN = "#";

    class Codec {

        public String serialize(TreeNode root) {
            return doSerialize(root, new StringBuilder()).toString();
        }

        private StringBuilder doSerialize(TreeNode root, StringBuilder builder) {
            if (root == null) builder.append(NN).append(SEPARATOR);
            else {
                builder.append(root.val).append(SEPARATOR);
                doSerialize(root.left, builder);
                doSerialize(root.right, builder);
            }

            return builder;
        }

        public TreeNode deserialize(String data) {
            return doDeserialize(new LinkedList<>(Arrays.asList(data.split(SEPARATOR))));
        }

        private TreeNode doDeserialize(Queue<String> dataList) {
            String root = dataList.remove();
            if (root.equals(NN)) return null;
            else {
                TreeNode node = new TreeNode(Integer.parseInt(root));
                node.left = doDeserialize(dataList);
                node.right = doDeserialize(dataList);

                return node;
            }
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
