class TrieNode(dict):
    def __init__(self, *args, **kwargs):
        self.end = False
        super(TrieNode, self).__init__(*args, **kwargs)


class Trie(object):

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        cur = self.root
        for char in word:
            node = cur.get(char)
            if node is None:
                node = TrieNode()
                cur[char] = node
            cur = node
        cur.end = True

    def search(self, word):
        cur = self.root
        for char in word:
            cur = cur.get(char)
            if cur is None:
                return False
        return cur.end

    def startsWith(self, prefix):
        cur = self.root
        for char in prefix:
            cur = cur.get(char)
            if cur is None:
                return False
        return True
