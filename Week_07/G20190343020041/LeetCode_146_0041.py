# 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
#
# 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
# 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
#
# 进阶:
#
# 你是否可以在 O(1) 时间复杂度内完成这两种操作？
#
# 示例:
#
# LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
#
# cache.put(1, 1);
# cache.put(2, 2);
# cache.get(1);       // 返回  1
# cache.put(3, 3);    // 该操作会使得密钥 2 作废
# cache.get(2);       // 返回 -1 (未找到)
# cache.put(4, 4);    // 该操作会使得密钥 1 作废
# cache.get(1);       // 返回 -1 (未找到)
# cache.get(3);       // 返回  3
# cache.get(4);       // 返回  4
#
# Related Topics 设计


# leetcode submit region begin(Prohibit modification and deletion)
class DLinkedNode:
    def __init__(self):
        self.key = 0
        self.value = 0
        self.prev = None
        self.next = None


class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.data = {}
        self.head, self.tail = DLinkedNode(), DLinkedNode()
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        node = self.data.get(key, None)
        if node is None:
            return -1
        self._move_to_head(node)
        return node.value

    def _move_to_head(self, node):
        self._remove_node(node)
        self._add_node(node)

    def put(self, key: int, value: int) -> None:
        node = self.data.get(key)
        if not node:
            if len(self.data) == self.capacity:
                n = self._pop_tail()
                del self.data[n.key]
            node = DLinkedNode()
            node.value = value
            node.key = key
            self._add_node(node)
            self.data[key] = node
        else:
            self._move_to_head(self.data[key])
            self.data[key].value = value

    def _pop_tail(self):
        n = self.tail.prev
        self._remove_node(n)
        return n

    def _remove_node(self, node):
        p = node.prev
        n = node.next
        n.prev = p
        p.next = n

    def _add_node(self, node):
        node.prev = self.head
        node.next = self.head.next
        self.head.next.prev = node
        self.head.next = node


# Your LRUCache object will be instantiated and called as such:

# leetcode submit region end(Prohibit modification and deletion)
obj = LRUCache(2)
obj.get("1")
for i in range(1, 6):
    obj.put(str(i >> 1), i)
    obj.get(str(i >> 1))
