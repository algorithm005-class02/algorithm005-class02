class Solution(object):
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if root is None:
            return []
        queue = []                                                   
        cur = [root] 					                             
        while cur:                                                   
            cur_layer_val = []                                       
            next_layer_node = []                                     
            for node in cur:                                         
                cur_layer_val.append(node.val)                       
                if node.children: next_layer_node += node.children   
            queue.append(cur_layer_val)                              
            cur = next_layer_node                                    
        return queue