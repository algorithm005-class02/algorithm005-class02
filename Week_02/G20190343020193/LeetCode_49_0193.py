import collections
class Solution(object):
    def groupAnagrams(self, strs):
        ans = collections.defaultdict(list) #生成defaultdict(<class 'list'>, {})
        for s in strs:
            ans[tuple(sorted(s))].append(s) 
		return ans.values() 