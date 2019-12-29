class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        process_list = [root]
        result_list = []
        
        while process_list and root:
            result_list.append([node.val for node in process_list])
            process_list = [item for pair in [(node.left, node.right) for node in process_list] for item in pair if item]
        return result_list
