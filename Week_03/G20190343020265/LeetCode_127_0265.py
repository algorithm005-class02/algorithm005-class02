#
# @lc app=leetcode.cn id=127 lang=python3
#
# [127] 单词接龙
#

# @lc code=start
from collections import deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        def construct_dict(word_list):
            d = {}
            for i in word_list:
                for j in range(len(i)):
                    str = i[:j] + '_' + i[j + 1:]
                    d[str] = d.get(str, []) + [i]
            return d
        
        def bfs_search(begin, end, d):
            queue, visited = deque([(begin, 1)]), set()
            while queue:
                word, step = queue.popleft()
                if word not in visited:
                    visited.add(word)
                    if word == end:
                        return step
                    for j in range(len(word)):
                        str = word[:j] + '_' + word[j + 1:]
                        neight_word = d.get(str, [])
                        for i in neight_word:
                            if i not in visited:
                                queue.append((i, step + 1))
            return 0
        d = construct_dict(wordList)
        return bfs_search(beginWord, endWord, d)

             
# @lc code=end

