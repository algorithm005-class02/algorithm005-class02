class Solution:
    def __init__(self):
        self.values = dict()

    def levelOrder(self, root: 'Node') -> List[List[int]]:
        # return self.use_queue(root)
        self.recursion(root)
        return self.values.values()

    def use_queue(self, root):
        """
        利用队列来广度遍历树结构。
        """
        values = list()
        queue = [root]
        while queue:
            current_level = list()     # 当前层的值
            for i in range(len(queue)): # 只遍历当前层的长度
                node = queue.pop(0)
                if node:
                    current_level.append(node.val)
                    queue.extend(node.children) # 下一层入队列
            if current_level:
                values.append(current_level)
        return values

    def recursion(self, root, level=0):
        """
        递归解决
        """
        # 1、终止条件
        if root:
            if level in self.values:
                self.values[level].append(root.val)
            else:
                self.values[level] = [root.val]
            
            if root.children:
                for i in root.children:
                    self.recursion(i, level+1)
        # 2、处理本层逻辑
        # 3、调用下一层
        # 4、清理
        else:
            return None


