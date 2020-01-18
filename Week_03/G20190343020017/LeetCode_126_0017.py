import collections

class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList):
        # 对字典进行预处理
        dictory = collections.defaultdict(set)
        for word in wordList:
            for i, char in enumerate(word):
                dictory[word[0:i] + '*' + word[i+1:]].add(word)
        # 广度搜索同时记录路径
        queue, visited, result = dict(), set(), []
        queue[''] = [beginWord]
        while queue:
            nextQueue, temp = collections.defaultdict(set), set()
            for path, words in queue.items():
                for word in words:
                    if word not in visited:
                        temp.add(word)
                        for i, char in enumerate(word):
                            if endWord in dictory[word[0:i] + '*' + word[i+1:]]:
                                result.append(path.split(",")[1:] + [word, endWord])
                            else:
                                nextQueue[path + ',' + word] |= dictory[word[0:i] + '*' + word[i+1:]]
            queue, visited = nextQueue, visited | temp
            # 如果已经有结果，直接返回
            if result:
                return result
        return []