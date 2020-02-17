# -*- encoding: utf-8 -*-
# Create on 2020/2/17

class Solution:
    def longestCommonPrefix_1(self, strs):
        if len(strs) == 1:
            return strs[0]
        if len(strs) == 0:
            return ""
        res= ""
        for x in range(len(strs[0])):
            standard = strs[0][x]
            for y in range(1, len(strs)):
                if x < len(strs[y]):
                    current = strs[y][x]
                else:
                    return res
                if current != standard:
                    return res
                elif current == standard:
                    if y == len(strs) - 1:
                        res += standard
        return res

    def longestCommonPrefix(self, strs):
        if not strs:
            return ""
        shortest = min(strs, key=len)
        for i, ch in enumerate(shortest):
            for other in strs:
                if other[i] != ch:
                    return shortest[:i]
        return shortest

if __name__ == '__main__':
    test = Solution()
    print(test.longestCommonPrefix(["flower","flow","flight"]))
    print(test.longestCommonPrefix(["dog","racecar","car"]))
    print(test.longestCommonPrefix(["aa","a"]))
    print(test.longestCommonPrefix(["a"]))
    print(test.longestCommonPrefix(["aa","ab"]))
    print(test.longestCommonPrefix([]))





