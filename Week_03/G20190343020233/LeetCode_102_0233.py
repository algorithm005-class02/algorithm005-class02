class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        process_list = [root]
        result_list = []
        
        while process_list and root:
            result_list.append([node.val for node in process_list])
            process_list = [item for pair in [(node.left, node.right) for node in process_list] for item in pair if item]
        return result_list

    def levelOrder_dfs(self, root: TreeNode) -> List[List[int]]:
        result_list = []

        if not root:
            return result_list
        def generate_result(level, node):
            if level == len(result_list):
                result_list.append([])
            if node:
                result_list[level].append(node.val)
            if node.left:
                generate_result(level+1, node.left)
            if node.right:
                generate_result(level+1, node.right)
        generate_result(0, root)
