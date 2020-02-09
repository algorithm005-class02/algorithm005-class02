# -*- encoding: utf-8 -*-
# Create by zq
# Create on 2020/2/8

class Solution:
    def totalNQueens(self, n):
        if n < 1:
            return 0
        def dfs(n, row, col, pie, na):
            nonlocal count
            if row >= n:
                count += 1
            print("col=%s" % bin(col))
            print("pie=%s" % bin(pie))
            print("na=%s" % bin(na))
            bits = ~(col | pie | na) & ((1 << n) - 1) #得到当前所有的空位
            print(f"{bin((col|pie|na))}")
            print(f"{bin(1 << n)}")
            print(f"{bin((1 << n) - 1)}")
            while bits:
                print(f"bits = {bin(bits)}")
                pos = bits & -bits #得到最低位的1
                bits = bits & (bits - 1) #清空最低位的1
                dfs(n, row + 1, col | pos, (pie | pos) << 1, (na | pos) >> 1)

        count = 0
        dfs(n, 0, 0, 0, 0)
        return count

if __name__ == '__main__':
    test = Solution()
    print(test.totalNQueens(4)) #2