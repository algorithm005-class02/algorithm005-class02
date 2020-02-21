class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        str ,nstr ,l= str.strip() ,"" ,['0','1','2','3','4','5','6','7','8','9','-','+']
        if not str or str[0] not in l:
            return 0
        for index,i in enumerate(str):
            if (index != 0 and (i == "-" or i== "+")) or i not in l:
                break
            else:
                nstr += i
        if ("-" in nstr and "+" in nstr )or (len(nstr)==1 and (nstr[0] == '-' or nstr[0]=='+')):
            return 0
        num = int(nstr)
        if num < -2147483648:
            return -2147483648
        if num > 2147483647:
            return 2147483647
        return num