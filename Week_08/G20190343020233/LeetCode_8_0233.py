# -*- encoding: utf-8 -*-
# Create on 2020/2/16

class Solution:
    def myAtoi_self(self, str):
        res = ""
        str = str.strip()
        if str == "":
            return 0
        str = str.split()[0]
        if str[0] in ("+", "-"):
            res += str[0]
            str = str[1:]
        for i in range(len(str)):
            try:
                if isinstance(int(str[i]), int):
                    res += str[i]
                else:
                    break
            except ValueError:
                break
        if res in ("", "+", "-"):
            return 0
        elif int(res) > 2147483647:
            return 2147483647
        elif int(res) < -2147483648:
            return -2147483648
        return int(res) if res else 0

    def myAtoi_self2(self, str):
        res = 0
        if len(str.strip()) == 0:
            return 0
        ls = str.strip().split()[0]
        sign = -1 if ls[0] == "-" else 1
        if ls[0] in ("-", "+"):
            ls = ls[1:]
        for item in ls:
            if item.isdigit():
                res = res * 10 + int(item)
            else:
                break
        return max(-2**31, min(sign * res, 2**30))

    def myAtoi(self, str):
        ls = list(str.strip())
        if len(ls) == 0: return 0
        sign = -1 if ls[0] == "-" else 1
        if ls[0] in ["-", "+"]: del ls[0]
        ret, i = 0, 0
        while i < len(ls) and ls[i].isdigit():
            ret = ret * 10 + ord(ls[i]) - ord('0')
            i += 1
        return max(-2 ** 31, min(sign * ret, 2 ** 31 - 1))



if __name__ == '__main__':
    test = Solution()
    print(test.myAtoi("+"))
    print(test.myAtoi("3.14159"))
    print(test.myAtoi("  -0012a42"))
    print(test.myAtoi(""))
    print(test.myAtoi("88"))
    print(test.myAtoi("  -88"))
    print(test.myAtoi("4193 with words"))
    print(test.myAtoi("words and 987"))
    print(test.myAtoi("-91283472332"))
    print(test.myAtoi("   "))
