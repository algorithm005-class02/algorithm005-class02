class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        def cut_text(text,lenth):
            textArr = re.findall('.{'+str(lenth)+'}', text)
            textArr.append(text[(len(textArr)*lenth):])
            return textArr
        s , ns = cut_text(s,k) , ""
        for i,v in enumerate(s):
            if i %2 != 0:
                ns += v
            else:
                ns += v[::-1]
        return ns
        


