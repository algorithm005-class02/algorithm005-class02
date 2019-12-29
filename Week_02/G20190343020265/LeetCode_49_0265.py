#
# @lc app=leetcode.cn id=49 lang=python3
#
# [49] 字母异位词分组
#

# @lc code=start
# 解法一，利用键值对映射方式，将数组里的每个str打散成tuple元组，并且以这个元组
# 作为键，收集符合元组元素的str的列表作为映射的值，最终输出映射值（即字典的值values)
# 这里还有个知识点需要注意：字典带默认值的初始化，这块刚好填补了【242.有效的字母异位词】
# 里面遇到的关于dict[i]当i不在键元素中时出现Keyerror的疑惑
# 其中collections.defaultdict的
# 更多解释可参考：https://blog.csdn.net/yangsong95/article/details/82319675

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        ans = collections.defaultdict(list)
        for i in strs:
            ans[tuple(sorted(i))].append(i)
        return ans.values()

# @lc code=end

