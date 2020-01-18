class Solution {
    public List<Integer> preorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        if (root == null) {
            return result;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollFirst();
            result.add(node.val);
            List<Node> reverseList = node.children;
            Collections.reverse(reverseList);
            for (Node item : reverseList) {
                if (item != null) {
                    stack.addFirst(item);
                }
            }
        }
        return result;
    }
}
