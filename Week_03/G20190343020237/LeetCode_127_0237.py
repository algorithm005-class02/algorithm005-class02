#
# @lc app=leetcode.cn id=127 lang=python3
#
# [127] 单词接龙
#
# https://leetcode-cn.com/problems/word-ladder/description/
#
# algorithms
# Medium (38.21%)
# Likes:    181
# Dislikes: 0
# Total Accepted:    17.6K
# Total Submissions: 45.6K
# Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
#
# 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
# 的最短转换序列的长度。转换需遵循如下规则：
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
# 示例 1:
#
# 输入:
# beginWord = "hit",
# endWord = "cog",
# wordList = ["hot","dot","dog","lot","log","cog"]
#
# 输出: 5
#
# 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
# ⁠    返回它的长度 5。
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
#
#

# @lc code=start
from typing import List
from collections import defaultdict, deque


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        # # DFS: O(n!)
        # # Time Limit Exceeded
        # # 19/40 cases passed (N/A)
        # ans = [0]

        # def distance(word1, word2):
        #     ans = 0
        #     for (u, v) in zip(word1, word2):
        #         if u != v: ans += 1
        #     return ans

        # def dfs(path: List[str]):
        #     if path[-1] == endWord:
        #         ans[0] = min(ans[0], len(path)) if ans[0] != 0 else len(path)
        #         return

        #     for word in wordList:
        #         if word not in path and distance(word, path[-1]) == 1:
        #             dfs(path + [word])

        # dfs([beginWord])
        # return ans[0]

        # # BFS: O(n!)
        # # Time Limit Exceeded
        # # 29/40 cases passed (N/A)
        # # ?改进预先算距离
        # if endWord not in wordList: return 0

        # def distance(word1, word2):
        #     ans = 0
        #     for (u, v) in zip(word1, word2):
        #         if u != v: ans += 1
        #     return ans

        # queue = [beginWord]
        # level = 1
        # used_word = set([beginWord])
        # while queue:
        #     for word in queue:
        #         if word == endWord: return level
        #     next_level = [next_word for word in queue for next_word in wordList if distance(word, next_word) == 1 and next_word not in used_word]
        #     for w in next_level: used_word.add(w)
        #     level += 1
        #     queue = next_level

        # return 0

        # BFS: 2019-12-29 17:02:11
        # Accepted
        # 40/40 cases passed (132 ms)
        # Your runtime beats 75.31 % of python3 submissions
        # Your memory usage beats 17.59 % of python3 submissions (15.9 MB)

        if endWord not in wordList or not beginWord: return 0  # shortcut
        len_word = len(beginWord)
        pattern2words = defaultdict(list)
        for word in wordList:
            for i in range(len_word):
                pattern2words[word[:i] + "*" + word[i + 1:]].append(word)
        queue = deque()
        queue.append([beginWord])
        level, used_words = 1, set([beginWord])
        while queue:
            words = queue.popleft()
            next_level_words = []
            for word in words:
                if word == endWord: return level
                for i in range(len_word):
                    for u in pattern2words[word[:i] + "*" + word[i + 1:]]:
                        if u not in used_words:
                            next_level_words.append(u)
                            used_words.add(u)
            if next_level_words:
                queue.append(next_level_words)
                level += 1
        return 0

# @lc code=end
