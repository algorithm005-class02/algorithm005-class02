class Solution {
    public List<Integer> postorder(Node root) {
      LinkedList<Node> stack  = new LinkedList<>();
        LinkedList<Integer> out = new LinkedList<>();
        if (root == null) {
             return out;
        }
        stack.add(root);
        while (!stack.isEmpty())  {
           Node  node = stack.pollLast();
           out.addFirst(node.val);
           for (Node item : node.children)  {
               if (item != null) {
                   stack.add(item);
               }
           }

        }
        return out;
    }
}