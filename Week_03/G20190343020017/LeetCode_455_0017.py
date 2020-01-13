class Solution:
    # 排序后贪心算法，首先满足胃口最大的
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        count = 0
        while g and s:
            if s[-1] >= g[-1]:
                count += 1
                g.pop()
                s.pop()
            else:
                g.pop()
        return count