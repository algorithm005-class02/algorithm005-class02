class Solution:
    # def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
    #
    #
    #     dict = {}
    #     for i in sorted(strs):
    #         key = tuple(sorted(i))
    #         dict[key] = dict.get(key,[]) + [i]
    #     return dict.values()


    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dict = {}
        for i in strs:
            key = ''.join(sorted(i))
            if key in dict:
                dict.get(key).append(i)
            else:
                dict[key] = [i]
        return dict.values()
