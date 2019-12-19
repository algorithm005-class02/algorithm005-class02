# week00
## 算法设计
1. 穷举法
2. 回溯法
3. 分治法和递归法
4. 贪心法和动态规划法

## 数组、链表、跳表
### 数组
数组：一个存储元素的线性集合，元素可以通过索引来任意存取，索引通常是数字，用来计算元素之间存储位置的偏移量。

js中数组是一种特殊的对象，用来表示偏移量的索引是该对象的属性，索引可能是整数。数字索引在内部会被转换为字符串类型。js中属性名必须是字符串。

1. 创建数组的方式
* var numbers = []
* var numbers = new Array()
2. 判断一个对象是否是数组
* Array.isArray()
3. 读写数组
用[]操作符将数据赋给数组，例：
> nums[i] = i + 1
4. 由字符串生成数组：split()
> var sentence = "the quick brown fox jumped over the lazy dog"
> var words = sentence.split("")
> for (var i = 0; i < words.length; ++i) {
>   &nbsp;&nbsp;&nbsp;console.log("word " + i + ":" + words[i])
> }
5. 对数组的整体性操作
浅复制：通过原引用修改了数组的值，另一个引用也会感知到这个变化。
> nums = []
> nums1 = [1, 2]
> nums = nums1
深拷贝：
> 法一：nums = JSON.parse(JSON.stringify(nums1))
> 法二：
<pre><code>
  function deepClone(obj) {
    let result = typeof  obj.splice === "function" ? [] : {};
    if (obj && typeof obj === 'object') {
        for (let key in obj) {
            if (obj[key] && typeof obj[key] === 'object') {
                result[key] = deepClone(obj[key]);//如果对象的属性值为object的时候，递归调用deepClone,即在吧某个值对象复制一份到新的对象的对应值中。
            } else {
                result[key] = obj[key];//如果对象的属性值不为object的时候，直接复制参数对象的每一个键值到新的对象对应的键值对中。
            }

        }
        return result;
    }
    return obj;
  }
</code></pre>
6. 存取函数
* 查找元素
&nbsp;indexOf()函数是常用的存取函数之一，如果目标数组包含该参数，就返回该元素在数组中的索引；如果不包含，就返回-1。
* 数组的字符串表示
&nbsp;有两个方法将数组转化为字符串：join()和toString()
* 由已有数组创建新数组
&nbsp;cancat()和splice()方法允许通过已有数组创建新数组。concat方法可以合并多个数组创建一个新数组，splice()方法截取一个数组的子集创建一个新数组。
7. 可变函数
* 为数组添加元素
&nbsp;push()将一个元素添加到数组末尾。
&nbsp;unshift()将一个元素添加到数组的开头。

### 链表
### 跳表

## 栈、队列、优先队列、双端队列