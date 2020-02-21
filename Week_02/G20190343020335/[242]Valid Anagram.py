#给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
#
# 示例 1: 
#
# 输入: s = "anagram", t = "nagaram"
#输出: true
# 
#
# 示例 2: 
#
# 输入: s = "rat", t = "car"
#输出: false 
#
# 说明: 
#你可以假设字符串只包含小写字母。 
#
# 进阶: 
#如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
# Related Topics 排序 哈希表



#leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # 长度不一致直接false
        if len(s) != len(t):
            return False
        # 方法一：一行解决 O(nlogn)
        # return sorted(s) == sorted(t)

        #方法二：hashmap计数
        count_map = {}
        for c in s:
            if count_map.get(c, -1) == -1:
                count_map[c] = 0
            count_map[c] += 1
        for c in t:
            if count_map.get(c, -1) == -1:
                return False
            count_map[c] -= 1
        for _, v in count_map:
            if v != 0:
                return False
        return True


#leetcode submit region end(Prohibit modification and deletion)
