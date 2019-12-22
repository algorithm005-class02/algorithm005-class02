class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < queue.size(); ++i) {
                Node curr = queue.poll();
                temp.add(curr.val);
                for (Node n : curr.children) {
                    queue.offer(n);
                }
            }
            ret.add(temp);
        }
        return ret;
    }
}
