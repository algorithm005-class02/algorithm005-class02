class Solution:
    def levelOrder(self, root):
        """这个漂亮"""
        path = []
        temp_list = [root]
        while any(temp_list):
            path.append([item.val for item in temp_list])
            temp_list = [child for node in temp_list for child in node.children if child]
        return path