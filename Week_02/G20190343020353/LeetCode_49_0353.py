"""
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

from collections import defaultdict


class Solution(object):
    """这道题的本质就是把同为异位词的不同字符串通过某种方式映射到同一位置"""

    def groupAnagrams1(self, strs):
        """
        定义一个字典，把每个字符串的排序后作为key，value为一个list，所有的异位词放在这个list中。
        """
        d = defaultdict(list)
        for s in strs:
            d[''.join(sorted(s))].append(s)
        return d.values()

    def groupAnagrams2(self, strs):
        """
        算术基本定理，又称为正整数的唯一分解定理，即：每个大于1的自然数，要么本身就是质数，要么可以写为2个以上的质数的积，
        而且这些质因子按大小排列之后，写法仅有一种方式。利用这个定理，我们可以把每个字符串都映射到一个正整数上。
        链接：https://leetcode-cn.com/problems/group-anagrams/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--16/
        """
        # 按从小到大顺序排列的26个质数
        prime = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103]
        d = defaultdict(list)
        for s in strs:
            k = 1
            for i in s:
                # 97是字母a的ascii值
                k *= prime[ord(i) - 97]
            d[k].append(s)
        return d.values()

    def groupAnagrams3(self, strs):
        """更加fancy一点的写法"""
        prime = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103]
        d = defaultdict(list)
        for s in strs:
            # 97是字母a的ascii值
            k = reduce(lambda x, y: x * y, [prime[ord(i) - 97] for i in s] or [0])
            d[k].append(s)
        return d.values()