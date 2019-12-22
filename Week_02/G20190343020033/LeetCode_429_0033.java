class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                //先获取到当前队列里的节点个数，防止后期因增加子节点导致循环次数增加
                int size = queue.size();
                List<Integer> level = new ArrayList<>();
                for(int i =0 ;i<size;i++){
                    Node node = queue.poll();
                    level.add(node.val);
                    queue.addAll(node.children);
                }
                result.add(level);
            }
        }
        return result;
    }
}