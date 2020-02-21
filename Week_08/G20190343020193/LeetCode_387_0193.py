import collections
class Solution:
    def firstUniqChar(self, s: str) -> int:

        # build hash map : character and how often it appears
        count = collections.Counter(s)  #Counter({'e':4,'l':2,'o':2,'v':1,'t':1,'c':1,'d':1})

        # find the index
        for idx, ch in enumerate(s): #idx:0 ch:'l'—>idx:1 ch:'o'—>idx:2 ch:'v'
            if count[ch] == 1:
                return idx
        return -1