# 第七周总结
## 16.位运算基础及实战要点
- 位运算符
- 算数移位与逻辑移位
- 位运算的应用
### 为什么需要位运算
- 机器里的数字表示方式和存储格式就是 二进制
####  位运算符
含义 | 运算符|  示例 
------------ | ------------- | -------------
左移 | <<  | 0011 => 0110
右移 | >>  | 0110 => 0011
按位或 | ｜  | 0011｜1011 => 1011 
按位与 | &  |  0011&1011 => 0011
左按位取反移 | ~  | 0011 => 1100
按位异或(相同为零不同为一) | ^  | 0011^1011=> 1000

#### N 皇后位运算代码示例
``` python
def totalNQueens(self, n): 
	if n < 1: return [] 
	self.count = 0 
	self.DFS(n, 0, 0, 0, 0) 
	return self.count

def DFS(self, n, row, cols, pie, na): 
	# recursion terminator 
	if row >= n: 
		self.count += 1 
		return

	bits = (~(cols | pie | na)) & ((1 << n) — 1)  # 得到当前所有的空位

	while bits: 
		p = bits & —bits # 取到最低位的1
		bits = bits & (bits — 1) # 表示在p位置上放入皇后
		self.DFS(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1) 
        # 不需要revert  cols, pie, na 的状态
```
#### N 皇后位运算代码-非位运算判重（Python）示例
``` python
def solveNQueens(self, n):
  def DFS(queens, xy_dif, xy_sum):
    p = len(queens)
    if p==n:
        result.append(queens)
        return None
    for q in range(n):
        if q not in queens and p-q not in xy_dif and \
          p+q not in xy_sum: 
            DFS(queens+[q], xy_dif+[p-q], xy_sum+[p+q])  
  result = []
  DFS([],[],[])
  return [ ["."*i + "Q" + "."*(n-i-1) for i in sol] for sol in result]
```

## 17.布隆过滤器和LRU缓存
### 布隆过滤器
- 布隆过滤器非常适合这种不需要 100% 准确的、允许存在小概率误判的大规模判重场景。除了爬虫网页去重这个例子，还有比如统计一个大型网站的每天的 UV 数，也就是每天有多少用户访问了网站，我们就可以使用布隆过滤器，对重复访问的用户，进行去重。
- 布隆过滤器的误判率，主要跟哈希函数的个数、位图的大小有关。当我们往布隆过滤器中不停地加入数据之后，位图中不是 true 的位置就越来越少了，误判率就越来越高了。所以，对于无法事先知道要判重的数据个数的情况，我们需要支持自动扩容的功能。
- 当布隆过滤器中，数据个数与位图大小的比例超过某个阈值的时候，我们就重新申请一个新的位图。后面来的新数据，会被放置到新的位图中。但是，如果我们要判断某个数据是否在布隆过滤器中已经存在，我们就需要查看多个位图，相应的执行效率就降低了一些。
- 位图、布隆过滤器应用如此广泛，很多编程语言都已经实现了。比如 Java 中的 BitSet 类就是一个位图，Redis 也提供了 BitMap 位图类，Google 的 Guava 工具包提供了 BloomFilter 布隆过滤器的实现。如果你感兴趣，你可以自己去研究下这些实现的源码。
- 参考王争老师课程
#### 布隆过滤器 Python 代码示例
``` python
from bitarray import bitarray 
import mmh3 

class BloomFilter: 
	def __init__(self, size, hash_num): 
		self.size = size 
		self.hash_num = hash_num 
		self.bit_array = bitarray(size) 
		self.bit_array.setall(0) 

	def add(self, s): 
		for seed in range(self.hash_num): 
			result = mmh3.hash(s, seed) % self.size 
			self.bit_array[result] = 1 

	def lookup(self, s): 
		for seed in range(self.hash_num): 
			result = mmh3.hash(s, seed) % self.size 
			if self.bit_array[result] == 0: 
				return "Nope" 
		return "Probably" 

bf = BloomFilter(500000, 7) 
bf.add("dantezhao") 
print (bf.lookup("dantezhao")) 
print (bf.lookup("yyj")) 
```
###  LRU Cache (least recently used)
- 两个要素: 大小 、替换策略
- Hash Table + Double LinkedList
- O(1) 查询; O(1) 修改、更新
#### LRU Cache Python代码示例
``` python
class LRUCache(object): 

	def __init__(self, capacity): 
		self.dic = collections.OrderedDict() 
		self.remain = capacity

	def get(self, key): 
		if key not in self.dic: 
			return -1 
		v = self.dic.pop(key) 
		self.dic[key] = v   # key as the newest one 
		return v 

	def put(self, key, value): 
		if key in self.dic: 
			self.dic.pop(key) 
		else: 
			if self.remain > 0: 
				self.remain -= 1 
			else:   # self.dic is full
				self.dic.popitem(last=False) 
		self.dic[key] = value
```
## 18.初级排序和高级排序的实现和特性
#### 快速排序代码示例
``` java
public static void quickSort(int[] array, int begin, int end) {
    if (end <= begin) return;
    int pivot = partition(array, begin, end);
    quickSort(array, begin, pivot - 1);
    quickSort(array, pivot + 1, end);
}

static int partition(int[] a, int begin, int end) {
    // pivot: 标杆位置，counter: 小于pivot的元素的个数
    int pivot = end, counter = begin;
    for (int i = begin; i < end; i++) {
        if (a[i] < a[pivot]) {
            int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
            counter++;
        }
    }
    int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
    return counter;
}
```
#### 归并排序代码示例
``` java
public static void mergeSort(int[] array, int left, int right) {
    if (right <= left) return;
    int mid = (left + right) >> 1; // (left + right) / 2

    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
}

public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 中间数组
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid)   temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
        // 也可以用 System.arraycopy(a, start1, b, start2, length)
    }
```
#### 堆排序代码示例
``` java
static void heapify(int[] array, int length, int i) {
    int left = 2 * i + 1, right = 2 * i + 2；
    int largest = i;

    if (left < length && array[left] > array[largest]) {
        largest = left;
    }
    if (right < length && array[right] > array[largest]) {
        largest = right;
    }

    if (largest != i) {
        int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
        heapify(array, length, largest);
    }
}

public static void heapSort(int[] array) {
    if (array.length == 0) return;

    int length = array.length;
    for (int i = length / 2-1; i >= 0; i-) 
        heapify(array, length, i);

    for (int i = length - 1; i >= 0; i--) {
        int temp = array[0]; array[0] = array[i]; array[i] = temp;
        heapify(array, i, 0);
    }
}
```