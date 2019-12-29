class Solution(object):
	def isAnagram(self, s, t):
		dic1, dic2 = [0]*26, [0]*26
		for item in s:
			dic1[ord(item)-ord('a')] += 1 
		for item in t:
			dic2[ord(item)-ord('a')] += 1
		return dic1 == dic2