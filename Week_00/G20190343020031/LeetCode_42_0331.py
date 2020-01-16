#!/usr/bin/env python3
# -*-coding:utf-8-*-


class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """

        # solution1:
        # return self.solution1_exhaustion(height)

        # solution2:
        return self.solution2_two_pointers(height)

    def solution1_exhaustion(self, height):
        water = 0
        left_max = {}
        right_max = {}
        for index in range(len(height)):
            left_max[index] = 0 if index == 0 else max(left_max[index - 1], height[index - 1])

        for index in range(len(height)):
            index = len(height) - 1 - index
            right_max[index] = (0 if index == len(height) - 1
                                else max(right_max[index + 1], height[index + 1])
                                )

        for index, value in enumerate(height):
            if min(left_max[index], right_max[index]) > value:
                water += min(left_max[index], right_max[index]) - value

        return water

    def solution2_two_pointers(self, height):
        water = 0
        left = 0
        right = len(height) - 1
        left_max = 0
        right_max = 0

        while left < right:
            if height[left] > height[right]:
                if right_max > height[right]:
                    water += right_max - height[right]
                else:
                    right_max = height[right]
                right -= 1
            else:
                if left_max >= height[left]:
                    water += left_max - height[left]
                else:
                    left_max = height[left]
                left += 1
        return water
