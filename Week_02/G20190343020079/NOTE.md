# 学习笔记

## 练习题

### 242 有效的字母异位词

#### 解法一：异位词排序之后一等相等

```java
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
  }
```

#### 解法二：26个字母映射到数组下标，第一个字符串+对应下标数字，第二个字符串减，最重数据所有index对应数字为零则为异位词

```java
class Solution {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
      counter[s.charAt(i) - 'a'] ++;
      counter[t.charAt(i) - 'a'] --;
    }

    for (int count : counter) {
      if (count != 0) return false;
    }

    return true;
  }
}
```

### 49 字母异位词分组

### 解法一：对字符排序，作为数组key，value为原字符串构成的列表

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> res = new HashMap<>();
    for (String s:strs) {
      char[] charArr = s.toCharArray();
      Arrays.sort(charArr);
      String sortedStr = new String(charArr);

      List<String> list = res.getOrDefault(sortedStr, new ArrayList<>());
      list.add(s);
      res.put(sortedStr, list);
    }

    List<List<String>> l = new ArrayList<>();
    for (Map.Entry<String, List<String>> entry:res.entrySet()) {
      l.add(entry.getValue());
    }
    return l;
    }
}
```

### 1 两数之和

````java
class Solution {
    public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] { map.get(complement), i };
      }
      map.put(nums[i], i);
    }
    return null;
    }
}
````

## 基本功

Golang Slice

1. 切片的底层都是基于数组的，数组的长度都是确定的

2. 切片包含三个变量，切片的开始位置（数组的地址），切片大小以及底层数组容量。

   ```go
   // runtime/slice.go
   type slice struct {
   	array unsafe.Pointer // 数组指针
   	len   int // 长度 
   	cap   int // 容量
   }
   ```

3. 如果两个切片都是从一个数组创建的就是共享同一个数组

4. 如果其中一个切片通过append超过底层数组容量，数组会扩容通过内置copy函数生成新的数组，切片中的数组指针会指向新的数组，这时候两个切片底层数组就不是一个了，扩容后的切片修改值，两个切片互不干涉

> https://blog.golang.org/go-slices-usage-and-internals
>
> https://www.zhihu.com/question/59659980

# 数学归纳法

> 数学归纳法:[https://zh.wikipedia.org/wiki/%E6%95%B0%E5%AD%A6%E5%BD%92%E7%BA%B3%E6%B3%95](https://zh.wikipedia.org/wiki/数学归纳法)

> 演绎推理: [https://zh.wikipedia.org/wiki/%E6%BC%94%E7%BB%8E%E6%8E%A8%E7%90%86](https://zh.wikipedia.org/wiki/演绎推理)

