import collections

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        # 对字典进行预处理
        dictory = collections.defaultdict(set)
        for word in wordList:
            for i, char in enumerate(word):
                dictory[word[0:i] + "*" + word[i+1:]].add(word)
        level, visited, length = [beginWord], set(), 1
        while level:
            nextLevel = []
            for word in level:
                if word in visited:
                    continue
                else:
                    visited.add(word)
                    for i, char in enumerate(word):
                        if endWord in dictory[word[0:i] + "*" + word[i+1:]]:
                            return length + 1
                        else:
                            nextLevel += list(dictory[word[0:i] + "*" + word[i+1:]])
            level, length = nextLevel, length + 1
        return 0