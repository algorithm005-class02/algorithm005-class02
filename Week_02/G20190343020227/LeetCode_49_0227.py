#!/usr/bin/python
# -*- coding: UTF-8 -*-
#自己想的一个方法，但是超时了，数据很大时效率太低
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        def compare(s,t):
            return sorted(s) == sorted(t)
        if not strs:return []
        l1,stack,temp = len(strs),[],[]
        for i in range(l1):
            if strs[i] == "0":continue
            temp.append(strs[i])
            j = i + 1
            l2 = len(strs[j:])
            for ii in range(l2):
                if compare(strs[i],strs[j]): #两两比较
                    temp.append(strs[j])
                    strs[j] = "0"  #已经符合条件的字母置标志位0
                j += 1
            stack.append(temp)
            temp = []
        return stack


#官方题解的方法 76ms
class Solution(object):
    def groupAnagrams(self, strs):
        if not strs:return []
        from collections import defaultdict 
        ans = defaultdict(list) #接受list为工厂函数，当key不存在时,返回list的默认值[]
        for s in strs: 
            ans[tuple(sorted(s))].append(s)  #键值必须加tuple，因为list是unhashable（不可哈希）的
        return ans.values() 