'''
 @method "计数法"
 @explain 对两个字符串进行去掉重复数字及数字顺序的操作,如果得出的新集合相同则再对比每个字符在对应字符串中的数量是否相等
 @complexity 时间复杂度： ,空间复杂度：O(1)
 @param {string} s
 @param {string} t
 @return {boolean}
'''
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # 1.利用set()方法去掉重复数字及数字顺序
        filter_str = set(s)
        if filter_str == set(t):
            for i in filter_str:
                # 2.利用count()方法来对比每个字符在对应字符串中的数量
                if s.count(i) != t.count(i):
                    return False
        else:
            return False
        return True
