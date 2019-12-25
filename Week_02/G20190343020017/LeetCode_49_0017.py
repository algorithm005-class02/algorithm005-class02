class Solution:
    # 方法一：循环匹配，单个样例通过，提交测试超时
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = []
        for s in strs:
            for m in result:
                if self.match(s, m[0]):
                    m.append(s)
                    break
            else:
                result.append([s])
        return result

    def match(self, str1, str2):
        if len(str1) != len(str2):
            return False
        s1 = "".join(sorted(str1))
        s2 = "".join(sorted(str2))
        return s1 == s2
    
    # 方法二：对匹配进行优化（仍然超时）
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = []
        sorted = []
        for s in strs:
            for i in range(len(result)):
                if self.match(s, sorted[i]):
                    result[i].append(s)
                    break
            else:
                result.append([s])
                sorted.append("".join(sorted(s)))
        return result

    def match(self, str1, str2):
        if len(str1) != len(str2):
            return False
        str1 = "".join(sorted(str1))
        return str1 == str2

    # 课后解题
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # 自己写
        '''
        m = {}
        for s in strs:
            ss = "".join(sorted(s))
            if ss in m:
                m[ss].append(s)
            else:
                m[ss] = []
        return m.values()
        '''
        # 参考题解
        m = collections.defaultdict(list)
        for s in strs:
            m[tuple(sorted(s))].append(s)
        return m.values()
        ''' 学到了
        1. 用 collections.defaultdict 初始化 map 略去了判断是否存在
        2. list 是 unhashable type，用 tuple 作为 key
        '''
