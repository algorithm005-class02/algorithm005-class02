class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        times = dict()
        for i in range(0, len(s)):
            s_alpha = s[i]
            if s_alpha in times:
                times[s_alpha] += 1
            else:
                times[s_alpha] = 1
        for i in range(0, len(t)):
            t_alpha = t[i]
            if t_alpha in times:
                times[t_alpha] -= 1
                if times[t_alpha] == 0:
                    times.pop(t_alpha)
            else:
                times[t_alpha] = 1
        if times:
            return False
        else:
            return True