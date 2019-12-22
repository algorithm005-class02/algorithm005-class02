# 两数之和（two-sum）

这是LeetCode上一道十分经典的题目，存在多种解法，难度是简单，但后面难度更高的三数之和、四数之和，其实也是由这道题演变而来的。

## 题目

> 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
>
> __示例:__
>
> 给定 nums = [2, 7, 11, 15], target = 9
>
> 因为 nums[0] + nums[1] = 2 + 7 = 9
>
> 所以返回 [0, 1]
>
> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/two-sum

## 解题

### 方法一： 暴力法

暴力法很逻辑很简单，采用两轮错位嵌循环，计算两个位置的数字之和是否等于目标值，因为题目中说明了只有两个整数的和是等于target，所以一旦找到直接 return 就行，十分简单粗暴。

```python
class Solution(object):
    def twoSum(self, nums, target):
        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return i, j
```

这种写法很好理解，得益于Python语言的简洁，上面核心部分的代码甚至可以简化为一行：

```python
chain.from_iterable([[i, j] for i in range(len(nums) - 1) for j in range(i + 1, len(nums)) if nums[i] + nums[j] == target])
```

因为是嵌套循环，所以时间复杂度是O($N^2$)，空间复杂度是O(1)，提交了也没毛病，在所有 python 提交中击败了31.08%的用户，这种方法在运行效率上不是很高。面试时如果没有太好的思路，可以尝试用暴力法来解决。如果能在短时间内写出上面的代码，至少说明你对语言本身还是很熟练的，代码的功底也还可以。



### 方法二：哈希大法

正确的思路是采取空间换时间的办法，使用一个哈希表缓存。思路如下：

1. 题目要求我们找出两个和为target的数，也就是 ```nums[i] + nums[j] = target```。

2. 转换一下，也就是 ```target - nums[i] = nums[j]```。

3. 把nums[i]和i以键值对的形式存到哈希表中，注意存的是__{值:下标}__这种格式 。

4. 由此可以看出，我们下次再遍历nums的时候，如果哈希表中存在一个数是target与当前数的差，那么那个数就是我们要找的数。而哈希表中查询的时间复杂度是O(1)，所以整体函数的效率提高了一个数量级。

5. 再一次循环nums，这次一边循环一边检索第4步存储的哈希表，如果能检索到，说明符合条件，立即返回，over。这里面有一个小坑，如果有一个数n，target与n的差恰好也等于n，这样就会在哈希表中查询到n自己，显示是不符合题目要求的，所以在判断的时候要注意过滤掉。

   代码如下：

   ```python
   class Solution(object):
       def twoSum(self, nums, target):
           d = {n: i for i, n in enumerate(nums)}
           for i, n in enumerate(nums):
             # 在哈希表中查询的时候，注意过滤掉当前数自身
               if target - n in d and d[target - n] != i:
                   return i, d[target - n]
   ```

   方法二一共遍历了两次nums，时间复杂度为O(2N)，同时引入一个新的字典，空间复杂度变成了O(N)，所以说是用空间换时间。

   

### 方法三：优化的哈希大法

方法二的其实还可以再优化一下，只用遍历一次nums就可以得到结果。在遍历的同时把数据写入哈希表中，并进行查询，这样最坏的情况下时间复杂度也就是O(N)。

```python
class Solution(object):
    def twoSum(self, nums, target):
        d = {}
        for i in range(len(nums)):
            if target - nums[i] in d:
                return i, d[target - nums[i]]
            d[nums[i]] = i
            
```

因为在字典中查询的时候，当前数字还没有放到哈希表中，所以省去了一个判断条件，代码逻辑变的更加简单。




