# LeetCode 01 | twoSum

### 方法一：

1. 遍历数组 nums
2. 如果 target - nums[i] 存在于 nums 中，则返回结果
3. 如果 nums 中不存在这样的两个数，返回 [-1, -1]
4. 复杂度分析：O(n)

```
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            if (target - nums[i]) in nums:
                if (nums.count(target - nums[i]) == 1) & (target - nums[i] == nums[i]):
                    continue
                else:
                    return [i, nums.index(target - nums[i], i+1)]
                    break
        return [-1, -1]
```



### 方法二：

1. 遍历数组 nums
2. 使用字典 hash{} 存储 nums 中的元素
3. 如果 target - nums[i] 存在于 hash{} 中，则返回结果；否则返回 [-1, -1]
4. 复杂度分析：O(n)

```
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash = {}
        for i in range(len(nums)):
            if target - nums[i] in hash:
                return [hash[target - nums[i]], i] 
            hash[nums[i]] = i
        return[-1, -1]
```



