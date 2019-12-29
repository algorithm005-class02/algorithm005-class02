class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        this.process(root,result);
        return result;
    }

    private void process(Node node,List<Integer> result){
        if(node != null && node.children != null){
            //后序遍历
            for(Node children:node.children){
                this.process(children,result);
            }
            result.add(node.val);
        }
    }
}