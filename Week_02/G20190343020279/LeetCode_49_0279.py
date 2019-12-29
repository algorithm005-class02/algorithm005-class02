'''
 @method "排序数组分类法"
 @explain 当且仅当它们的排序字符串相等时，两个字符串是字母异位词。
 @complexity 时间复杂度：O(NKlogK) ,空间复杂度：O(KN)
 @param {string[] strs
 @return {List[List[str]]}
'''
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # 1.设置字典的key的默认值
        box = collections.defaultdict(list)
        for s in strs:
            # 2.将遍历出来的字符串排序、元组化，然后加到字典里
            box[tuple(sorted(s))].append(s)
            # 3.以列表返回字典中的所有值
        return box.values()
