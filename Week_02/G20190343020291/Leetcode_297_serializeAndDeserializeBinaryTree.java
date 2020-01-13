import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的序列化与反序列化
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class Leetcode_297_serializeAndDeserializeBinaryTree {

    /**
     * 序列化的格式自己制定，保证可以反序列化即可
     */
    private final static String NullStr = "#";
    private final static String Spliter = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NullStr).append(Spliter);
            return;
        }

        sb.append(root.val).append(Spliter);
        buildString(root.left, sb);
        buildString(root.right, sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(Spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NullStr)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);
        return root;
    }
}
