#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#

# @lc code=start
# 解法一，暴力破解法，通过内置函数sorted对字符串数组进行排序，然后对比两个数组是否相同
# 然后这里怎么分析时间复杂度呢？ 自己写的或者是看到别人的代码怎么快速判断复杂度呢？
# class Solution:
#     def isAnagram(self, s: str, t: str) -> bool:
#         s_sort = sorted(list(s))
#         t_sort = sorted(list(t))
#         if len(s_sort) != len(t_sort):
#             return False
#         for i in range(len(s_sort)):
#             if s_sort[i] != t_sort[i]:
#                 return False
#         return True

# 解法二，hash表解法，在python这就使用 dict字典的数据结构存储 键值对，以每个字母为
# 键key，字母出现的次数为values值，然后对比dict是否相同
# 这里编程卡了半个小时！！！ 主要是dict那里，判断dict是否存在键值对时，直接用dict[i]
# 这样会返回 keyerror，因为不能直接对不存在的键去获取dict的值
# 后来修改为 if i in dict, 即改为判断键是否在dict字典的键组里，不要直接赋值即可
# 再者，后续判断相加值为0 时要注意取绝对值后再相加，防止正负相加为0的错误值出现
# 虽然时间和空间复杂度低，但还是觉得代码不够简洁

# class Solution:
#     def isAnagram(self, s: str, t: str) -> bool:
#         s_dict = {}
#         values = 0
#         for i in s:
#             if i in s_dict:
#                 s_dict[i] += 1
#             else:
#                 s_dict[i] = 1     
#         for i in t:
#             if i in s_dict: 
#                 s_dict[i] -= 1
#             else:
#                 return False     
#         for i in s_dict:
#             values += abs(s_dict[i])
#         if values == 0:
#             return True
#         else:
#             return False


# 解法三， 改进解法二，达到更简洁
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        s_dict = {}
        t_dict = {}
        values = 0
        for i in s:
            s_dict[i] = s_dict.get(i, 0) + 1
        for i in t:
            t_dict[i] = t_dict.get(i, 0) + 1
        return s_dict == t_dict

# @lc code=end

