public class Codec {

  public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += String.valueOf(root.val) + ",";
            str  = rserialize(root.left, str);
            str  = rserialize(root.right, str);
        }
        return str;
    }

    public TreeNode rdeserialize(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = rdeserialize(list);
        root.right = rdeserialize(list);
        return root;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         String[] data_array = data.split(",");
        List<String>  data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }
}