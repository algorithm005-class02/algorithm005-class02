#
# @lc app=leetcode.cn id=208 lang=python3
#
# [208] 实现 Trie (前缀树)
#
# https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
#
# algorithms
# Medium (62.49%)
# Likes:    182
# Dislikes: 0
# Total Accepted:    20.9K
# Total Submissions: 32.8K
# Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
#
# 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
# 
# 示例:
# 
# Trie trie = new Trie();
# 
# trie.insert("apple");
# trie.search("apple");   // 返回 true
# trie.search("app");     // 返回 false
# trie.startsWith("app"); // 返回 true
# trie.insert("app");   
# trie.search("app");     // 返回 true
# 
# 说明:
# 
# 
# 你可以假设所有的输入都是由小写字母 a-z 构成的。
# 保证所有输入均为非空字符串。
# 
# 
#

# @lc code=start
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.end = False
        self.c = {}
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self
        for w in word:
            if w not in node.c:
                node.c[w] = Trie()
            node = node.c[w]
        node.end = True
    
    def prefixNode(self, word):
        node = self
        for w in word:
            if w not in node.c:
                return None
            node = node.c[w]
        return node

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.prefixNode(word)
        if not node:
            return False
        else:
            return True if node.end else False
        
    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        return bool(self.prefixNode(prefix))


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
# @lc code=end

