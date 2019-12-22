class Solution {
    public List<Integer> postorder(Node root) {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return  result;
        }
        //result.add(new ArrayList<>(Arrays.asList(root.val)));
        help(root, result, 0);
        return result;
    }

    public void help(Node root, List<List<Integer>> result, int n) {
        if (root == null) {
            return;
        }

        if (result.size() < n+1) {
            result.add(new ArrayList<>());
        }

        result.get(n).add(root.val);
        for (Node item : root.children) {
            help(item, result, n+1);
        }
    }
}
