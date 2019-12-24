class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # v1 字符串排序
        # times = dict()
        # for i in strs:
        #     sotred_s = tuple(sorted(i))
        #     if sotred_s in times:
        #         times[sotred_s].append(i)
        #     else:
        #         times[sotred_s] = [i]
        # return times.values()

        # v2 用字符计数
        times = dict()
        for i in strs:
            counter = [0] * 26
            for s in i:
                counter[ord(s)-ord('a')] += 1   # 计数
            key = tuple(counter)
            if key in times:
                times[key].append(i)
            else:
                times[key] = [i]
        return times.values()

