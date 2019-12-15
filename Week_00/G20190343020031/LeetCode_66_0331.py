#!/usr/bin/env python3
# -*-coding:utf-8-*-


class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        # solution1:
        # return list(str(int(''.join(map(str, digits))) + 1))

        # solution2:
        result = []
        over_10 = True
        for i in range(len(digits)):
            if over_10:
                if digits[len(digits) - 1 - i] + 1 >= 10:
                    result.append(0)
                    over_10 = True
                else:
                    result.append(digits[len(digits) - 1 - i] + 1)
                    over_10 = False
            else:
                result.append(digits[len(digits) - 1 - i])
        if over_10:
            result.append(1)
        return reversed(result)
