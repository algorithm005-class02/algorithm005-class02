import string
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):

        if endWord not in wordList: return 0

        front = {beginWord}  
        back = {endWord}
        word_len = len(beginWord)
        dist = 1  
        wordList = set(wordList)

        while front and back:  
            dist += 1
            next_front = set()

            for word in front:
                for i in range(word_len):
                    for c in string.lowercase:  
                        if c != word[i]:
                            new_word = word[:i] + c + word[i + 1:]  
                            if new_word in back:  
                                return dist  
                            if new_word in wordList:
                                next_front.add(new_word)
                                wordList.remove(new_word)  
            front = next_front  
            if len(back) < len(front):  
                front, back = back, front

        return 0 