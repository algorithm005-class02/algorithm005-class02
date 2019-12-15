# LeetCode 66 | plusOne

### 方法一：

1. 遍历数组 digits
2. 将数组内的数字累加，然后 +1 得到新的整数
3. 对整数进行取余运算，将余数存到一个新的数组
4. 逆序数组，输出结果
5. 复杂度分析：O(n)

```
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        num = 0
        for i in digits:
            num = num * 10 + i
        
        num += 1
        output = []

        while num:
            temp = num % 10
            num //= 10
            output.append(temp)
        
        return output[::-1]
```



