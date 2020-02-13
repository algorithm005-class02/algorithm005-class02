# 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
#
#
# 每次转换只能改变一个字母。
# 转换过程中的中间单词必须是字典中的单词。
#
#
# 说明:
#
#
# 如果不存在这样的转换序列，返回 0。
# 所有单词具有相同的长度。
# 所有单词只由小写字母组成。
# 字典中不存在重复的单词。
# 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
#
#
# 示例 1:
#
# 输入:
# beginWord = "hit",
# endWord = "cog",
# wordList = ["hot","dot","dog","lot","log","cog"]
#
# 输出: 5
#
# 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
#     返回它的长度 5。
#
#
# 示例 2:
#
# 输入:
# beginWord = "hit"
# endWord = "cog"
# wordList = ["hot","dot","dog","lot","log"]
#
# 输出: 0
#
# 解释: endWord "cog" 不在字典中，所以无法进行转换。
# Related Topics 广度优先搜索


# leetcode submit region begin(Prohibit modification and deletion)
from collections import deque
from typing import List


class Solution:

    def ladderLengthBFS(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList: return 0
        d = self.construct_dict(set(wordList) | set([beginWord, endWord]))
        queue, visited = deque([(beginWord, 1)]), set()
        while queue:
            current_word, level = queue.popleft()
            if current_word == endWord:
                return level
            visited.add(current_word)
            for i in range(len(beginWord)):
                s = current_word[:i] + "_" + current_word[i + 1:]
                neigh_words = d.get(s, [])
                for nw in neigh_words:
                    if nw not in visited:
                        queue.append((nw, level + 1))

        return 0

    def ladderLength(self, beginWord: str, endWord: str, __wordList: List[str]) -> int:
        if endWord not in __wordList: return 0
        wordList = set(__wordList)
        d = self.construct_dict(wordList | set([beginWord, endWord]))
        queue_begin, queue_end, visited = set([beginWord]), set([endWord]), set([beginWord])
        level = 1
        while queue_begin:
            level += 1
            next_queue = set()
            for current_word in queue_begin:
                for i in range(len(beginWord)):
                    s = current_word[:i] + "_" + current_word[i + 1:]
                    neigh_words = d.get(s, [])
                    for nw in neigh_words:
                        if nw in queue_end:
                            return level
                        if nw not in visited:
                            next_queue.add(nw)
                            visited.add(nw)
            queue_begin = next_queue
            if len(queue_begin) > len(queue_end):
                queue_begin, queue_end = queue_end, queue_begin
        return 0

    def construct_dict(self, word_list):
        d = {}
        for word in word_list:
            for i in range(len(word)):
                s = word[:i] + "_" + word[i + 1:]
                d[s] = d.get(s, []) + [word]
        return d


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().ladderLength("hot", "dog", ["hot", "dog"]))
