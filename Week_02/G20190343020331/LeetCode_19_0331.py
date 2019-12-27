#!/usr/bin/env python3
# -*-coding:utf-8-*-

class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        def gen(curr, left):
            if not left:
                ret.append(curr)
                return

            for i in left:
                _l = set(left)
                _l.remove(i)
                gen(curr + [i], list(_l))

        ret = []
        gen([], nums)
        return ret
