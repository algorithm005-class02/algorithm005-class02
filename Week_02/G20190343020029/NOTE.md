## 哈希表、映射、集合
##### 哈希表（散列）
1. 哈希表（散列表）是根据关键码值（key value）而直接进行访问的数据结构。通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。
2. 应用
* hash主要用于信息安全领域中加密算法，把一些不同长度的信息转化杂乱的128位的编码，这些编码值叫做hash值，hash就是找到一种数据内容和数据存放地址之间的映射关系。
* 查找：知道key值之后，直接计算出这个元素在集合中的位置。
* 处理海量数据
3. hash是找到一种数据内容和数据存放地址之间的映射关系。
&nbsp;散列法：元素特征转变为数组下标的方法。
&nbsp;注：两个字符串在hash表中对应位置相同：转成链表，在哈希表的每个入口挂一个链表，保存所有对应的字符串。
4. 散列表的查找步骤
&nbsp;1)存储时，通过散列函数计算出记录的散列地址
&nbsp;2)查找时，通过散列函数计算记录的散列地址，并按照散列地址访问该记录。
5. 理想情况下，散列函数会将每个键值映射为一个唯一的数组索引。然而，键的数量是无限的，数组的长度是有限的，一个更现实的目标是让散列函数尽量将键值均匀地映射到数组中。
6. 使用一个高效的散列函数，存在将两个键值映射成同一个值的可能（碰撞）
7. 实现
<pre><code>
function HashTable() {
  this.table = new Array(137)
  this.simpleHash = simpleHash
  this.showDistro = showDistro
  this.put = put
}
</code></pre>
<pre><code>
function put(data) {
  var pos = this.simpleHash(data)
  this.table[pos] = data
}
</code></pre>
<pre><code>
function simpleHash(data) {
  var total = 0
  for(var i = 0; i < data.length; ++i) {
    total += data.charCodeAt(i)
  }
  return total % this.table.length
}
</code></pre>
##### 映射
##### 集合
## 树、二叉树、二叉搜索树
##### 树
##### 二叉树
##### 二叉搜索树
## 泛型递归、树的递归
##### 泛型递归
##### 树的递归