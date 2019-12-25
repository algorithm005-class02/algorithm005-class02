class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        this.process(root,result);
        return result;
    }

    private void process(Node node,List<Integer> result){
        if(node != null && node.children != null){
            //前序遍历
            result.add(node.val);
            for(Node children:node.children){
                this.process(children,result);
            }

        }
    }
}