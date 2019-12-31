from utils.timer import timethis


class Solution:
    """
    # 是否忽略大小写？
    # 1。 暴力？遍历后加入dict, O(n)
    # 2。 老师讲的先排序，再比较 O(NlogN)?
    """
    @timethis
    def isAnagram_myself_1(self, s: str, t: str) -> bool:
        """
        1. first look up the first str and add to a dict named dict_tool
        2. look up the second str and remove from the dict_tool
        3. look up dict_tool to see if value is 0
        """

        if len(s) != len(t):
            return False
        dict_tool = {}
        for chs in s:
            if chs not in dict_tool.keys():
                dict_tool[chs] = 1
            else:
                dict_tool[chs] += 1
        for cht in t:
            if cht not in dict_tool.keys():
                return False
            else:
                dict_tool[cht] -= 1
        for value in dict_tool.values():
            if value != 0:
                return False
        else:
            return True

    @timethis
    def isAnagram_myself_2(self, s: str, t: str) -> bool:
        """
        1. pop a ch from the first str
        2. check if the poped ch in the second str
        """
        for ch in s:
            if ch not in t:
                return False
            else:
                t = t.replace(ch, "", 1)
        if t != "":
            return False
        else:
            return True

    @timethis
    def isAnagram_myself_3(self, s: str, t: str) -> bool:
        """
        老师讲的排序的方式
        """
        return sorted(s) == sorted(t)

    @timethis
    def isAnagram2(self, s, t):
        """
        网友用两个dict的解法，写得比我短太多了
        不懂为何要用它的ascii值来做key，不是多了一步转换的时间吗？
        """
        dic1, dic2 = [0] * 26, [0] * 26
        for item in s:
            dic1[ord(item) - ord('a')] += 1
        for item in t:
            dic2[ord(item) - ord('a')] += 1
        return dic1 == dic2

if __name__ == "__main__":
    test = Solution()
    print(test.isAnagram_myself_1("anagram", "nagaram"))
    print(test.isAnagram_myself_2("anagram", "nagaram"))
    print(test.isAnagram_myself_3("anagram", "nagaram"))
    print(test.isAnagram2("anagram", "nagaram"))

