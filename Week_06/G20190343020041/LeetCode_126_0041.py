# 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
#
#
# 每次转换只能改变一个字母。
# 转换过程中的中间单词必须是字典中的单词。
#
#
# 说明:
#
#
# 如果不存在这样的转换序列，返回一个空列表。
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
# 输出:
# [
#  ["hit","hot","dot","dog","cog"],
#   ["hit","hot","lot","log","cog"]
# ]
#
#
# 示例 2:
#
# 输入:
# beginWord = "hit"
# endWord = "cog"
# wordList = ["hot","dot","dog","lot","log"]
#
# 输出: []
#
# 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
# Related Topics 广度优先搜索 数组 字符串 回溯算法


# leetcode submit region begin(Prohibit modification and deletion)
import collections
import string
from typing import List


class Solution:

    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        if endWord not in wordList: return []
        tree, words, n = collections.defaultdict(set), set(wordList), len(beginWord)
        found, bq, eq, nq, rev = False, set([beginWord]), set([endWord]), set(), False
        while bq and not found:
            words -= bq
            for word in bq:
                for new_word in [word[:i] + c + word[i + 1:] for i in range(n) for c in string.ascii_lowercase]:
                    if new_word in words:
                        if new_word in eq:
                            found = True
                        else:
                            nq.add(new_word)
                        tree[new_word].add(word) if rev else tree[word].add(new_word)
            bq, nq = nq, set()
            if len(bq) > len(eq):
                bq, eq, rev = eq, bq, not rev

        def dfs(x):
            return [[x]] if x == endWord else [[x] + rest for y in tree[x] for rest in dfs(y)]

        return dfs(beginWord)

    def findLaddersBFS(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        if endWord not in wordList: return []
        tree, words, n = collections.defaultdict(set), set(wordList), len(beginWord)
        found, queue, next_queue = False, set([beginWord]), set()
        while queue and not found:
            words -= queue
            for word in queue:
                for new_word in [word[:i] + c + word[i + 1:] for i in range(n) for c in string.ascii_lowercase]:
                    if new_word in words:
                        if new_word == endWord:
                            found = True
                        else:
                            next_queue.add(new_word)
                        tree[word].add(new_word)
            queue, next_queue = next_queue, set()

        def dfs(x):
            return [[x]] if x == endWord else [[x] + rest for y in tree[x] for rest in dfs(y)]

        return dfs(beginWord)


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().findLadders("red",
                             "tax",
                             ["ted", "tex", "red", "tax", "tad", "den", "rex", "pee"])
      )
