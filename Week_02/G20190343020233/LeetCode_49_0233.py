# Given an array of strings, group anagrams together.
#
# Example:
#
#
# Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
# Output:
# [
#  ["ate","eat","tea"],
#  ["nat","tan"],
#  ["bat"]
# ]
#
# Note:
#
#
# All inputs will be in lowercase.
# The order of your output does not matter.
#
# Related Topics Hash Table String


# leetcode submit region begin(Prohibit modification and deletion)
from utils.timer import timethis


class Solution:
    """
    1. 复用之前242题判断是否为anagram的方法，新增一个dict来记录多个anagram组
    2. 提交的时候超时了
    """
    @timethis
    def groupAnagrams1(self, strs):
        """
        解法一
        """
        group_dict = {}
        for item in strs:
            if group_dict == {}:
                group_dict[item] = [item]
            else:
                for word in group_dict:
                    if self.is_anagram(word, item):
                        group_dict[word].append(item)
                        break
                    else:
                        continue
                else:
                    group_dict[item] = [item]

        return list(group_dict.values())

    @timethis
    def groupAnagrams2(self, strs):
        """
        解法二, 耗时超过89%
        """
        group_dict = {}
        for item in strs:
            key = ''.join(sorted(item))
            if not group_dict:
                group_dict[key] = [item]
            elif key not in group_dict.keys():
                group_dict[key] = [item]
            else:
                group_dict[key].append(item)
        return list(group_dict.values())

    @timethis
    def groupAnagrams3(self, strs):
        """
        网友的解法:
        精妙的地方在于使用到了dict的默认值
        """
        d = {}
        for w in sorted(strs):
            key = tuple(sorted(w))
            d[key] = d.get(key, []) + [w]
        return d.values()

    @timethis
    def groupAnagrams4(self, strs):
        """
        结合网友的优秀思想改写的
        """
        group_dict = {}
        for item in strs:
            key = "".join(sorted(item))
            group_dict[key] = group_dict.get(key, []) + [item]
        return group_dict.values()


    def is_anagram(self, s: str, t: str) -> bool:
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

if __name__ == '__main__':
    test = Solution()
    print(test.groupAnagrams1(["eat","tea","tan","ate","nat","bat"]))
    print(test.groupAnagrams2(["eat","tea","tan","ate","nat","bat"]))
    print(test.groupAnagrams3(["eat","tea","tan","ate","nat","bat"]))
    print(test.groupAnagrams4(["eat","tea","tan","ate","nat","bat"]))
