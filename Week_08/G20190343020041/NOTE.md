###
滑动窗口找子串问题，模板
双指针模拟窗口
1. 先移动j,找到符合条件的window
2. 再移动left, 优化找到的window结果, 如果window不符合条件则继续移动j 
3. 直到j结束

时间复杂度 O(2M+N)
2M = 两个指针一共走的步数，也就是循环的部署
N= 初始化 目标字串 需要的时间 

``` python

m = Counter(p)
counter = len(m)
i, j, n, d = 0, 0, len(s), len(p)
res = []
while j < n:
    if s[j] in m:
        m[s[j]] -= 1
        if m[s[j]] == 0:  # 条件需根据具体情况变化
            counter -= 1
    j += 1
    while counter == 0:  # 条件需根据具体情况变化
        if j - i == d:
            res.append(i)
        if s[i] in m:
            m[s[i]] += 1
            if m[s[i]] > 0:  # 条件需根据具体情况变化
                counter += 1
        i += 1
return res

```
类似题
https://leetcode.com/problems/minimum-window-substring/
https://leetcode.com/problems/longest-substring-without-repeating-characters/
https://leetcode.com/problems/substring-with-concatenation-of-all-words/
https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
https://leetcode.com/problems/find-all-anagrams-in-a-string/