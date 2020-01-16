# -*- encoding: utf-8 -*-
# Create by zq
# Create on 2020/1/16


class Trie:
    def __init__(self):
        self.root = {}
        self.end = "#"

    def insert(self, word):
        node = self.root
        for ch in word:
            node = node.setdefault(ch, {})
        node[self.end] = self.end

    def search(self, word):
        node = self.root
        for ch in word:
            if ch not in node:
                return False
            node = node[ch]
        return self.end in node

    def startsWith(self, word):
        node = self.root
        for ch in word:
            if ch not in node:
                return False
            node = node(ch)
        return True

class Solution:
    def findWords(self, board, words):
        res = set()
        trie = Trie()
        for word in words:
            trie.insert(word)
        node = trie.root
        for i in range(len(board)):
            for j in range(len(board[i])):
                self.dfs(board, node, i, j, res, "")
        return list(res)

    def dfs(self, board, node, i, j, res, bingo):
        if "#" in node:
            res.add(bingo)
        if i < 0 or j < 0 or i == len(board) or j == len(board[0]):
            return
        if board[i][j] not in node:
            return
        cur_w = board[i][j]
        board[i][j] = "$"
        self.dfs(board, node[cur_w], i + 1, j, res, bingo + cur_w)
        self.dfs(board, node[cur_w], i - 1, j, res, bingo + cur_w)
        self.dfs(board, node[cur_w], i, j + 1, res, bingo + cur_w)
        self.dfs(board, node[cur_w], i, j - 1, res, bingo + cur_w)
        board[i][j] = cur_w

if __name__ == '__main__':
    board = [
     ['o','a','a','n'],
     ['e','t','a','e'],
     ['i','h','k','r'],
     ['i','f','l','v']
    ]
    words = ["oath","pea","eat","rain"]
    test = Solution()
    print(test.findWords(board, words))







